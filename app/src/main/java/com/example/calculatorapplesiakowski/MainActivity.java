package com.example.calculatorapplesiakowski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String numSelected = "";

    private double num1;
    private double num2;

    private boolean onNum1 = true;
    private boolean onNum2 = false;

    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double calculate(){

        String beforeOperator = operator;
        operator = "";

        if(beforeOperator.equals("+")){
            return num1 + num2;
        }
        else if(beforeOperator.equals("-")){
            return num1 - num2;
        }
        else if(beforeOperator.equals("x")){
            return num1*num2;
        }
        else{
            return num1/num2;
        }



    }

    //Make sense of input and calculates accordingly
    public void getNumSelected(View v) {

        Button butSelected = findViewById(v.getId());
        TextView input = findViewById(R.id.inputText);

        //EQUAL
        if(butSelected.getText().equals("=")){

            num2 = Double.parseDouble(numSelected);
            numSelected = "";
            Log.i("Oliver", "NUM 2 Is " + num2);

            Double calculatedNum = calculate();

            input.setText(Double.toString(calculatedNum));

            //IN CASE USER WANTS TO DO MORE WITH ANSWER

            num1 = calculatedNum;
            numSelected = Double.toString(num1);
        }

        //CLEAR
        else if(butSelected.getText().equals("C")){
            input.setText("");
            numSelected = "";
            num1 = 0;
            num2 = 0;
            operator = "";
            onNum2 = false;
        }
        else if(butSelected.getTag().equals("Number") && !onNum2 && onNum1) {
            numSelected += butSelected.getText();
            input.setText(numSelected);
        }

        else if(butSelected.getTag().equals("Operator")){
            operator += butSelected.getText();
            num1 = Double.parseDouble(numSelected);
            numSelected = "";
            onNum2 = true;
            onNum1 = false;
            Log.i("Oliver", "NUM 1 Is " + num1);
        }

        else{
            numSelected += butSelected.getText();
            input.setText(numSelected);
        }


    }
}