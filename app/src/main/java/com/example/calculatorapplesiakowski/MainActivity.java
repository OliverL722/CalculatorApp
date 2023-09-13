package com.example.calculatorapplesiakowski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String numSelected = "";

    private double num1;
    private double num2;

    private boolean isOperationSelected = false;
    private boolean oneDecimal = false;

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
        else {
            return num1/num2;
        }
    }

    public void clearButBackgrounds(View v){
        /**
         *  Holy moly was this hard to get, to set a button background to one of my colors.xml colors, you first have to grab
         *  the resource file, where you grab color, in which you grab the xml color file, weird? Applied from chatGPT
         */
        findViewById(R.id.buttonDivide).setBackgroundColor(getResources().getColor(R.color.strokeOutsideDark));
        findViewById(R.id.buttonMultiply).setBackgroundColor(getResources().getColor(R.color.strokeOutsideDark));
        findViewById(R.id.buttonSubtract).setBackgroundColor(getResources().getColor(R.color.strokeOutsideDark));
        findViewById(R.id.buttonClear).setBackgroundColor(getResources().getColor(R.color.strokeOutsideDark));
        findViewById(R.id.buttonAdd).setBackgroundColor(getResources().getColor(R.color.strokeOutsideDark));

    }

    //Make sense of input and calculates accordingly
    public void getNumSelected(View v) {

        Button butSelected = findViewById(v.getId());
        TextView input = findViewById(R.id.inputText);

        //EQUAL
        if(butSelected.getText().equals("=")){

            clearButBackgrounds(v);
            num2 = Double.parseDouble(numSelected);
            numSelected = "";
            Log.i("Oliver", "NUM 2 Is " + num2);

            Double calculatedNum = calculate();

            input.setText(Double.toString(calculatedNum));

            //IN CASE USER WANTS TO DO MORE WITH ANSWER

            num1 = calculatedNum;
            numSelected = Double.toString(num1);
            oneDecimal = true;
        }

        else if(butSelected.getText().equals(".") && oneDecimal == false){
            isOperationSelected = false;
            numSelected += butSelected.getText();
            input.setText(numSelected);
            oneDecimal = true;
        }

        //CLEAR
        else if(butSelected.getText().equals("C")){
            input.setText("");
            numSelected = "";
            num1 = 0;
            num2 = 0;
            operator = "";
            oneDecimal = false;
        }

        else if(butSelected.getTag().equals("Number") && !butSelected.getText().equals(".")) {
            isOperationSelected = false;
            numSelected += butSelected.getText();
            input.setText(numSelected);
        }

        else if(butSelected.getTag().equals("Operator") && isOperationSelected == false){
            clearButBackgrounds(v);
            butSelected.setBackgroundColor(Color.CYAN);
            isOperationSelected = true;
            operator = "";
            operator += butSelected.getText();
            num1 = Double.parseDouble(numSelected);
            numSelected = "";
            oneDecimal = false;
            Log.i("Oliver", "NUM 1 Is " + num1);
        }

        //IF USER SELECTS OTHER OPERATOR
        else if(isOperationSelected == true){
            clearButBackgrounds(v);
            butSelected.setBackgroundColor(Color.CYAN);
            operator = "";
            operator += butSelected.getText();
        }
    }
}