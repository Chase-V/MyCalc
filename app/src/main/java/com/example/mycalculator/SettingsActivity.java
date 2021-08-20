package com.example.mycalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    static final int dayTheme = 1;
    static final int nightTheme = 2;
    static final String keySharedPrefs = "sp";
    static final String keyCurrentTheme = "current_theme";
    static Resources.Theme currentTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealStyle(getCurrentTheme()));
        setContentView(R.layout.settings_activity);

        currentTheme = getTheme();

        initRadio();

    }

    private void initRadio() {
        RadioButton radioDay = findViewById(R.id.radioLight);
        RadioButton radioNight = findViewById(R.id.radioDark);
        Button buttonReturn = findViewById(R.id.buttonReturn);

        radioDay.setOnClickListener(this);
        radioNight.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);

        switch (getCurrentTheme()) {
            case 1:
                radioDay.setChecked(true);
                break;
            case 2:
                radioNight.setChecked(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioLight:
                setCurrentTheme(dayTheme);
                break;
            case R.id.radioDark:
                setCurrentTheme(nightTheme);
                break;
            case R.id.buttonReturn:
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                String theme = currentTheme.toString();
                intent.putExtra(MainActivity.currentThemeKey, String.valueOf(currentTheme));
                setResult(RESULT_OK, intent);
                finish();
        }
        recreate();
    }

    private void setCurrentTheme(int currentTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(keySharedPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(keyCurrentTheme, currentTheme);
        editor.apply();
    }

    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(keySharedPrefs, MODE_PRIVATE);
        return (sharedPreferences.getInt(keyCurrentTheme, -1));
    }

    private int getRealStyle(int currentTheme) {
        switch (currentTheme) {
            case dayTheme:
                return R.style.Theme_MyCalculator_Day;
            case nightTheme:
                return R.style.Theme_MyCalculator_Night;
            default:
                return 0;
        }
    }
}