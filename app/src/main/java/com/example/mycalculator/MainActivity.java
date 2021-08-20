package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final char addition = '+';
    private static final char subtraction = '-';
    private static final char multiplication = '*';
    private static final char division = '/';
    private static final char module = '%';
    private final String CurrentNumbersKey = "CurrentNumbers";
    private final String HistoryNumbersKey = "HistoryNumbers";
    private final String Val1Key = "Val1";
    private final String Val2Key = "Val2";
    private final String CurrentActionKey = "CurrentAction";
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAC;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonPercent;
    private Button buttonDelete;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonEquals;
    private Button buttonDot;
    private Button buttonNegative;
    private Button buttonSettings;
    private TextView currentNumbers;
    private TextView historyNumbers;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private DecimalFormat decimalFormat;
    private char currentAction;
    static final String currentThemeKey = "CurrentTheme";
    private final int Req_code = 1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        decimalFormat = new DecimalFormat("#.##########");

        super.onCreate(savedInstanceState);

        setTheme(SettingsActivity.currentTheme);

        setContentView(R.layout.activity_main);

        initViews();

        initListeners();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString(CurrentNumbersKey, currentNumbers.getText().toString());
        outState.putString(HistoryNumbersKey, historyNumbers.getText().toString());
        outState.putDouble(Val1Key, valueOne);
        outState.putDouble(Val2Key, valueTwo);
        outState.putChar(CurrentActionKey, currentAction);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        currentNumbers.setText(savedInstanceState.getString(CurrentNumbersKey));
        historyNumbers.setText(savedInstanceState.getString(HistoryNumbersKey));
        valueOne = savedInstanceState.getDouble(Val1Key);
        valueTwo = savedInstanceState.getDouble(Val2Key);
        currentAction = savedInstanceState.getChar(CurrentActionKey);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button0:
                currentNumbers.append("0");
                break;

            case R.id.button1:
                currentNumbers.append("1");
                break;

            case R.id.button2:
                currentNumbers.append("2");
                break;

            case R.id.button3:
                currentNumbers.append("3");
                break;

            case R.id.button4:
                currentNumbers.append("4");
                break;

            case R.id.button5:
                currentNumbers.append("5");
                break;

            case R.id.button6:
                currentNumbers.append("6");
                break;

            case R.id.button7:
                currentNumbers.append("7");
                break;

            case R.id.button8:
                currentNumbers.append("8");
                break;

            case R.id.button9:
                currentNumbers.append("9");
                break;

            case R.id.buttonDot:
                if (currentNumbers.getText().toString().contains(".")) {
                    break;
                } else currentNumbers.append(".");
                break;

            case R.id.buttonAC:
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                currentNumbers.setText("");
                historyNumbers.setText("");
                break;

            case R.id.buttonPlus:
                computeCalculation();
                currentAction = addition;
                historyNumbers.setText(decimalFormat.format(valueOne) + "+");
                currentNumbers.setText(null);
                break;

            case R.id.buttonMinus:
                computeCalculation();
                currentAction = subtraction;
                historyNumbers.setText(decimalFormat.format(valueOne) + "-");
                currentNumbers.setText(null);
                break;

            case R.id.buttonMultiply:
                computeCalculation();
                currentAction = multiplication;
                historyNumbers.setText(decimalFormat.format(valueOne) + "*");
                currentNumbers.setText(null);
                break;

            case R.id.buttonDivide:
                computeCalculation();
                currentAction = division;
                historyNumbers.setText(decimalFormat.format(valueOne) + "/");
                currentNumbers.setText(null);
                break;

            case R.id.buttonNegative:
                if (currentNumbers.length() > 0) {
                    currentNumbers.setText(decimalFormat.format(Double.parseDouble(currentNumbers.getText().toString()) * (-1)));
                }
                break;

            case R.id.buttonPercent:
                computeCalculation();
                currentAction = module;
                historyNumbers.setText(decimalFormat.format(valueOne) + "%");
                currentNumbers.setText(null);
                break;

            case R.id.buttonEquals:
                computeCalculation();
                historyNumbers.setText(historyNumbers.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                currentNumbers.setText(decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                currentAction = '0';
                break;

            case R.id.buttonDelete:
                if (currentNumbers.length() > 0) {
                    currentNumbers.setText(currentNumbers.getText().toString().substring(0, currentNumbers.length() - 1));
                    break;
                } else break;

            case R.id.buttonSettings:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(i, Req_code);

            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Req_code) {
            recreate();
        }
    }

    private void initListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonNegative.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);
    }

    private void initViews() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAC = findViewById(R.id.buttonAC);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonDot = findViewById(R.id.buttonDot);
        buttonNegative = findViewById(R.id.buttonNegative);
        currentNumbers = findViewById(R.id.textViewCurrentNums);
        historyNumbers = findViewById(R.id.textViewOperationHistory);
        buttonSettings = findViewById(R.id.buttonSettings);
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(currentNumbers.getText().toString());
            currentNumbers.setText(null);

            if (currentAction == addition)
                valueOne = this.valueOne + valueTwo;
            else if (currentAction == subtraction)
                valueOne = this.valueOne - valueTwo;
            else if (currentAction == multiplication)
                valueOne = this.valueOne * valueTwo;
            else if (currentAction == division)
                valueOne = this.valueOne / valueTwo;
            else if (currentAction == module)
                valueOne = this.valueOne % valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(currentNumbers.getText().toString());
            } catch (Exception e) {
            }
        }
    }

}
