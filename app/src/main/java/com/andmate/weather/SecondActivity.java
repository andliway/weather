package com.andmate.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    static final String TEXT_DATA_KEY = "text_data_key";
    private Button btnsearch;
    private TextView edittext;
    private Switch beginnerSwitch;
    private Switch secondSwitch;
    private Switch thirdSwitch;
    private TextView textView;
    private TextView textViewTwo;
    private TextView textViewThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        setOnBtnBackMainActivityBtnClick();
        setOnSwitchChangedTwoSec();
        setOnSwitchChangedSec();
        setOnSwitchChangedThreeSec();
    }

    private void initViews() {
        btnsearch = findViewById(R.id.button);
        edittext = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView6);
        textViewTwo = findViewById(R.id.textView7);
        textViewThree = findViewById(R.id.textView8);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch = findViewById(R.id.switch1);
            secondSwitch = findViewById(R.id.switch2);
            thirdSwitch = findViewById(R.id.switch3);
        }
    }

    private void setOnBtnBackMainActivityBtnClick() {
        btnsearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra(TEXT_DATA_KEY,edittext.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void setOnSwitchChangedSec() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.celsius);
                    } else {
                        text = getString(R.string.fahrenheit);
                    }
                    textView.setText(text);
                }
            });
        }
    }

    private void setOnSwitchChangedTwoSec() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            secondSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.mm);
                    } else {
                        text = getString(R.string.mbar);
                    }
                    textViewTwo.setText(text);
                }
            });
        }
    }

    private void setOnSwitchChangedThreeSec() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            thirdSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.m_s);
                    } else {
                        text = getString(R.string.km_h);
                    }
                    textViewThree.setText(text);
                }
            });
        }
    }
}
