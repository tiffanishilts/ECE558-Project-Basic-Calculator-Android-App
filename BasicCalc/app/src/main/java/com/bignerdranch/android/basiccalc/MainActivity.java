/*
Basic Calculator Application
Inputs: Two positive decimal numbers input from user
Outputs: Results of arithmetic in double floating point
Copyright Tiffani M. Shilts Portland, OR January 2021
 */

package com.bignerdranch.android.basiccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private EditText minput1;
    private EditText minput2;

    private TextView moutput;

    private Button mCalcAddButton;
    private Button mCalcSubButton;
    private Button mCalcMultiButton;
    private Button mCalcDivButton;
    private Button mCalcPercentButton;
    private Button mCalcSqrtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign id to variables
        minput1 = (EditText) findViewById(R.id.editText_op1);
        minput2 = (EditText) findViewById(R.id.editText_op2);

        moutput = (TextView) findViewById(R.id.textView_result);

        // implement addition function
        mCalcAddButton = (Button) findViewById(R.id.button_op_plus);
        mCalcAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, true)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter two positive decimal numbers.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Double.valueOf(minput1.getText().toString()) +
                            Double.valueOf(minput2.getText().toString());
                    moutput.setText("" + result);
                }
            }
        });

        // implement subtraction function
        mCalcSubButton = (Button) findViewById(R.id.button_op_minus);
        mCalcSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, true)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter two positive decimal numbers.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Double.valueOf(minput1.getText().toString()) -
                            Double.valueOf(minput2.getText().toString());
                    moutput.setText("" + result);
                }
            }
        });

        // implement multiplication function
        mCalcMultiButton = (Button) findViewById(R.id.button_op_multi);
        mCalcMultiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, true)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter two positive decimal numbers.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Double.valueOf(minput1.getText().toString()) *
                            Double.valueOf(minput2.getText().toString());
                    moutput.setText("" + result);
                }
            }
        });

        // implement divide function
        mCalcDivButton = (Button) findViewById(R.id.button_op_div);
        mCalcDivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, true) || (Double.valueOf(minput2.getText().toString()) == 0)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter two positive decimal numbers." +
                                    "You may not divide by zero.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Double.valueOf(minput1.getText().toString()) /
                            Double.valueOf(minput2.getText().toString());
                    moutput.setText("" + result);
                }
            }
        });

        // implement percent function
        mCalcPercentButton = (Button) findViewById(R.id.button_op_pct);
        mCalcPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, false)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter a positive number decimal for operand one.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Double.valueOf(minput1.getText().toString()) / 100.0;
                    moutput.setText("%" + result);
                }
            }
        });

        // implement square root function
        mCalcSqrtButton = (Button) findViewById(R.id.button_op_sqrt);
        mCalcSqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidInput(true, false)) {
                    Toast.makeText(MainActivity.this,
                            "Please enter a positive decimal number for operand one.",
                            Toast.LENGTH_SHORT).show();

                    clear_input();

                    minput1.requestFocus();
                } else {
                    double result = Math.sqrt(Double.valueOf(minput1.getText().toString()));
                    moutput.setText("" + result);
                }
            }
        });

    }

    // input true/false for needed input. will return true if there is input greater than or equal to zero in the needed input, false otherwise
    private boolean isValidInput(boolean NeedI1, boolean NeedI2)
    {
        String inputOneString = minput1.getText().toString();
        String inputTwoString = minput2.getText().toString();

        if (NeedI1)
        {
            if (inputOneString.length() == 0)
            {
                return false;
            }
            else if (Double.parseDouble(inputOneString) < 0.00)
            {
                return false;
            }
        }

        if (NeedI2)
        {
            if (inputTwoString.length() == 0)
            {
                return false;
            }
            else if (Double.parseDouble(inputTwoString) < 0.00)
            {
                return false;
            }
        }

        return true;
    }

    // clear both operands and result text
    private void clear_input()
    {
        minput1.setText("");
        minput2.setText("");
        moutput.setText("");
    }
}

