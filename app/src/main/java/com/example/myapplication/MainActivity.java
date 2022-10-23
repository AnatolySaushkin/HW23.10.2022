package com.example.myapplication;

import static android.graphics.Typeface.DEFAULT;
import static android.graphics.Typeface.ITALIC;
import static android.graphics.Typeface.MONOSPACE;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    private EditText mMessageEditText;
    private CheckBox mColorCheckBox;
    private Switch mBoldSwitch;
    private ToggleButton mtoggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Счетчик Ворон");

        mMessageEditText = (EditText) findViewById(R.id.editText);
        mColorCheckBox = (CheckBox) findViewById(R.id.checkBoxColor);
        mBoldSwitch = (Switch) findViewById(R.id.switchBold);
        mtoggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        Button mCrowsCounterButton = (Button) findViewById(R.id.buttonCounter);
        ToggleButton mAppToggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        mAppToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMessageEditText.setText("Я насчитал " + ++mCount + " ворон");
                            if (mColorCheckBox.isChecked())
                                mMessageEditText.setTextColor(Color.RED);
                            else
                                mMessageEditText.setTextColor(Color.BLACK);

                            if (mBoldSwitch.isChecked())
                                mMessageEditText.setTypeface(Typeface.DEFAULT_BOLD);
                            else
                                mMessageEditText.setTypeface(DEFAULT);
                        }
                    });
                } else {
                    mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMessageEditText.setText("Я насчитал " + mCount + " ворон");
                        }
                    });
                }
            }
        });
    }
}
