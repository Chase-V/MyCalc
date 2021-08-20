package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondApp extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_app);

        Button launchCalculatorButton;
        launchCalculatorButton = findViewById(R.id.launchCalcuatorButton);
        launchCalculatorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,Intent.CATEGORY_APP_CALCULATOR));
        startActivity(i);
    }
}