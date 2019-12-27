package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GPACalculator extends AppCompatActivity {
    public static Spinner[] gpaContainers;
    public static Spinner[] creditContainers;
    private Button getGPAButton;
    private TextView overallGPA;

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);

        setGPASpinners(); setCreditSpinners();

        getGPAButton = (Button) findViewById(R.id.getGPA);
        overallGPA = (TextView) findViewById(R.id.overallGPA);

        getGPAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float currGPA; Float currCred;
                Float gpa_sum = 0.0f;
                Integer num_courses = gpaContainers.length;
                for (int i = 0; i<gpaContainers.length; i++) {
                    currGPA = Float.parseFloat(gpaContainers[i].getSelectedItem().toString().substring(0,3));
                    System.out.println(currGPA);
                    currCred = Float.parseFloat(creditContainers[i].getSelectedItem().toString());

                    if (currCred == 0.0) {num_courses += -1;}
                    else {
                        if (currCred == 1.0) {gpa_sum += currGPA*2; num_courses += 1;}
                        else {gpa_sum += currGPA;}
                    }
                }

                Float overall = 0.0f;
                if (num_courses != 0) { overall=gpa_sum/num_courses;}

                overallGPA.setText(df.format(overall));
            }
        });

    }

    public void setGPASpinners(){
        Spinner sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8;

        sgpa1 = findViewById(R.id.GPA1);
        sgpa2 = findViewById(R.id.GPA2);
        sgpa3 = findViewById(R.id.GPA3);
        sgpa4 = findViewById(R.id.GPA4);
        sgpa5 = findViewById(R.id.GPA5);
        sgpa6 = findViewById(R.id.GPA6);
        sgpa7 = findViewById(R.id.GPA7);
        sgpa8 = findViewById(R.id.GPA8);

        ArrayAdapter<String> myGPAAdapter = new ArrayAdapter<String>(GPACalculator.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gpasUTSC));
        myGPAAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gpaContainers = new Spinner[] {sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8};

        for (int i = 0; i < gpaContainers.length; i++){
            gpaContainers[i].setAdapter(myGPAAdapter);
        }
    }

    public void setCreditSpinners(){
        Spinner credit1,credit2,credit3,credit4,credit5,credit6,credit7,credit8;

        credit1 = findViewById(R.id.credit1);
        credit2 = findViewById(R.id.credit2);
        credit3 = findViewById(R.id.credit3);
        credit4 = findViewById(R.id.credit4);
        credit5 = findViewById(R.id.credit5);
        credit6 = findViewById(R.id.credit6);
        credit7 = findViewById(R.id.credit7);
        credit8 = findViewById(R.id.credit8);

        ArrayAdapter<String> myCredAdapter = new ArrayAdapter<String>(GPACalculator.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.credits));
        myCredAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        creditContainers = new Spinner[] {credit1,credit2,credit3,credit4,credit5,credit6,credit7,credit8};

        for (int i = 0; i < creditContainers.length; i++){
            creditContainers[i].setAdapter(myCredAdapter);
        }

    }
}
