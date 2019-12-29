package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradeCalculator extends AppCompatActivity {

    Button calculate_button;
    TextView average1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculator);
        calculate_button = (Button)findViewById(R.id.calculate_button);
        average1 = (TextView)findViewById(R.id.average1);
        calculate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String end = doMath();
                average1.setText(end);
            }
        });
    }

    public String doMath(){
        EditText grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10;
        EditText percent1, percent2, percent3, percent4, percent5, percent6, percent7, percent8,
                percent9, percent10;
        float mark = 0, current = 0;
        double roundOff;
        grade1 = (EditText) findViewById(R.id.grade1);
        grade2 = (EditText) findViewById(R.id.grade2);
        grade3 = (EditText) findViewById(R.id.grade3);
        grade4 = (EditText) findViewById(R.id.grade4);
        grade5 = (EditText) findViewById(R.id.grade5);
        grade6 = (EditText) findViewById(R.id.grade6);
        grade7 = (EditText) findViewById(R.id.grade7);
        grade8 = (EditText) findViewById(R.id.grade8);
        grade9 = (EditText) findViewById(R.id.grade9);
        grade10 = (EditText) findViewById(R.id.grade10);
        EditText[] grades = {grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10};

        percent1 = (EditText) findViewById(R.id.percent1);
        percent2 = (EditText) findViewById(R.id.percent2);
        percent3 = (EditText) findViewById(R.id.percent3);
        percent4 = (EditText) findViewById(R.id.percent4);
        percent5 = (EditText) findViewById(R.id.percent5);
        percent6 = (EditText) findViewById(R.id.percent6);
        percent7 = (EditText) findViewById(R.id.percent7);
        percent8 = (EditText) findViewById(R.id.percent8);
        percent9 = (EditText) findViewById(R.id.percent9);
        percent10 = (EditText) findViewById(R.id.percent10);
        EditText[] percentages = {percent1,percent2,percent3,percent4,percent5,percent6,
                percent7,percent8,percent9,percent10};

        for(int i=0; i<10; i++){
            if(Float.parseFloat(percentages[i].getText().toString()) != 0){
                mark += Float.parseFloat(grades[i].getText().toString())
                        * (Float.parseFloat(percentages[i].getText().toString()) / 100);
                current += Float.parseFloat(percentages[i].getText().toString());
            }
        }
        roundOff = Math.round((mark / current) * 100);
        String end = "Average is " + String.valueOf(roundOff) + "% of "
                + String.valueOf(current) + "% done";
        return end;
    }

}
