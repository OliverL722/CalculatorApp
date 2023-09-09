package com.example.calculatorapplesiakowski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String numSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getNumSelected(View v) {
        if (v.getId() == R.id.buttonOne) {
            Log.i("Oliver", "Selected one!");
            numSelected += 1;
        } else if (v.getId() == R.id.buttonTwo) {
            Log.i("Oliver", "Selected two!");
            numSelected += 2;
        } else if (v.getId() == R.id.buttonThree) {
            Log.i("Oliver", "Selected three!");
            numSelected += 3;
        } else if (v.getId() == R.id.buttonFour) {
            Log.i("Oliver", "Selected four!");
            numSelected += 4;
        } else if (v.getId() == R.id.buttonFive) {
            Log.i("Oliver", "Selected five");
            numSelected += 5;
        } else if (v.getId() == R.id.buttonSix) {
            Log.i("Oliver", "Selected six!");
            numSelected += 6;
        } else if (v.getId() == R.id.buttonSeven) {
            Log.i("Oliver", "Selected seven!");
            numSelected += 7;
        } else if (v.getId() == R.id.buttonEight) {
            Log.i("Oliver", "Selected eight!");
            numSelected += 8;
        } else if (v.getId() == R.id.buttonNine) {
            Log.i("Oliver", "Selected nine!");
            numSelected += 9;
        } else if (v.getId() == R.id.buttonZero) {
            Log.i("Oliver", "Selected zero!");
            numSelected += 0;
        } else if (v.getId() == R.id.buttonPeriod) {
            Log.i("Oliver", "Selected .!");
            numSelected += ".";
        } else if (v.getId() == R.id.buttonAdd) {
            Log.i("Oliver", "Selected +!");
            numSelected += "+";
        } else if (v.getId() == R.id.buttonSubtract) {
            Log.i("Oliver", "Selected -!");
            numSelected += "-";
        } else if (v.getId() == R.id.buttonMultiply) {
            Log.i("Oliver", "Selected x!");
            numSelected += "x";
        } else if (v.getId() == R.id.buttonDivide) {
            Log.i("Oliver", "Selected /!");
            numSelected += "/";
        } else if (v.getId() == R.id.buttonClear) {
            Log.i("Oliver", "Selected C!");
            numSelected += "C";
        } else if (v.getId() == R.id.buttonEqual) {
            Log.i("Oliver", "Selected =!");
            numSelected += "=";
        }

        TextView input = findViewById(R.id.inputText);
        input.setText(numSelected);
    }
}