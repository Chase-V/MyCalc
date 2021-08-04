package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonAC;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonPercent;
    Button buttonDelete;
    Button buttonMinus;
    Button buttonPlus;
    Button buttonEquals;
    Button buttonDot;
    TextView currentNums;
    TextView historyNums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initListeners();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button0:
                currentNums.append("0");
                break;
            case R.id.button1:
                currentNums.append("1");
                break;
            case R.id.button2:
                currentNums.append("2");
                break;
            case R.id.button3:
                currentNums.append("3");
                break;
            case R.id.button4:
                currentNums.append("4");
                break;
            case R.id.button5:
                currentNums.append("5");
                break;
            case R.id.button6:
                currentNums.append("6");
                break;
            case R.id.button7:
                currentNums.append("7");
                break;
            case R.id.button8:
                currentNums.append("8");
                break;
            case R.id.button9:
                currentNums.append("9");
                break;
            case R.id.buttonDot:
                if (currentNums.getText().toString().contains(".")) {
                    break;
                } else currentNums.append(".");
                break;
            case R.id.buttonAC:
                currentNums.setText("");
                historyNums.setText("");
                break;
            case R.id.buttonPlus:
                historyNums.append(currentNums.getText()+"+");
                currentNums.setText("");
                break;
            case R.id.buttonMinus:
                historyNums.append(currentNums.getText()+"-");
                currentNums.setText("");
                break;
            case R.id.buttonDelete:
                if (currentNums.length()>0){
                    currentNums.setText(currentNums.getText().toString().substring(0, currentNums.length()-1));
                    break;
                } else break;
            default:
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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
        buttonEquals.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
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
        currentNums = findViewById(R.id.textViewCurrentNums);
        historyNums = findViewById(R.id.textViewOperationHistory);
    }
}
