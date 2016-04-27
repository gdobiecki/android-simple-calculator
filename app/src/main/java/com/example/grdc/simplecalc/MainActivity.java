package com.example.grdc.simplecalc;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE = "Give the numbers.";
    private Button btnAdd;
    private Button btnSubtraction;
    private Button btnMultiply;
    private Button btnDivide;
    private EditText etFirst;
    private EditText etSecond;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        final String num1 = etFirst.getText().toString();
        final String num2 = etSecond.getText().toString();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    Toast.makeText(MainActivity.this, MESSAGE, Toast.LENGTH_SHORT).show();
                } else {
                    int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    result.setText(MESSAGE);
                } else {
                    int subtraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                    result.setText(String.valueOf(subtraction));
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    result.setText(MESSAGE);
                } else {
                    int multiplication = Integer.parseInt(num1) * Integer.parseInt(num2);
                    result.setText(String.valueOf(multiplication));
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    result.setText(MESSAGE);
                } else {
                    try {
                        int division = Integer.parseInt(num1) / Integer.parseInt(num2);
                        result.setText(String.valueOf(division));
                    } catch (IllegalArgumentException e) {
                        result.setText("Division by zero is not allowed.");
                    }
                }
            }
        });
    }

    private void init() {
        btnAdd = (Button) findViewById(R.id.addBtn);
        btnSubtraction = (Button) findViewById(R.id.subtractionBtn);
        btnMultiply = (Button) findViewById(R.id.multiplyBtn);
        btnDivide = (Button) findViewById(R.id.divideBtn);
        etFirst = (EditText) findViewById(R.id.firstNum);
        etSecond = (EditText) findViewById(R.id.secondNum);
        result = (TextView) findViewById(R.id.result);

    }
}
