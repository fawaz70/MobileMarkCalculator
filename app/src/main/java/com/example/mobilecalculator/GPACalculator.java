package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GPACalculator extends AppCompatActivity {
    private Float gpa1,gpa2,gpa3,gpa4,gpa5,gpa6;
    private Float c1,c2,c3,c4,c5,c6;
    private Spinner credit1,credit2,credit3,credit4,credit5,credit6;
    private Button getGPAButton;
    private TextView currGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);
        credit1 = (Spinner) findViewById(R.id.credit1);
        credit2 = (Spinner) findViewById(R.id.credit2);
        credit3 = (Spinner) findViewById(R.id.credit3);
        credit4 = (Spinner) findViewById(R.id.credit4);
        credit5 = (Spinner) findViewById(R.id.credit5);
        credit6 = (Spinner) findViewById(R.id.credit6);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(GPACalculator.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.credits));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        credit1.setAdapter(myAdapter); credit2.setAdapter(myAdapter); credit3.setAdapter(myAdapter);
        credit4.setAdapter(myAdapter); credit5.setAdapter(myAdapter); credit6.setAdapter(myAdapter);

        getGPAButton = (Button) findViewById(R.id.getGPA);
        currGPA = (TextView) findViewById(R.id.currGPA);

        getGPAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get all the gpas from the text fields
                this.assignGPAs();

                // Get all the credits from the spinner
                this.assignCredits();

                Float[] credits = {c1,c2,c3,c4,c5,c6};
                Float[] gpa = {gpa1,gpa2,gpa3,gpa4,gpa5,gpa6};
                Float gpa_sum = 0.0f;
                Integer num_courses = credits.length;
                for (int i = 0; i<credits.length; i++) {
                    if (credits[i] == 0.0f) {
                        num_courses += -1;
                    } else {
                        if (credits[i] == 1.0) {
                            gpa_sum += gpa[i]*2;
                        } else {gpa_sum += gpa[i];}
                    }
                }
                Float overall = gpa_sum/num_courses;

                currGPA.setText(overall.toString());
            }

            public void assignGPAs(){
                gpa1 = Float.parseFloat(((EditText) findViewById(R.id.GPA1)).getText().toString());
                gpa2 = Float.parseFloat(((EditText) findViewById(R.id.GPA2)).getText().toString());
                gpa3 = Float.parseFloat(((EditText) findViewById(R.id.GPA3)).getText().toString());
                gpa4 = Float.parseFloat(((EditText) findViewById(R.id.GPA4)).getText().toString());
                gpa5 = Float.parseFloat(((EditText) findViewById(R.id.GPA5)).getText().toString());
                gpa6 = Float.parseFloat(((EditText) findViewById(R.id.GPA6)).getText().toString());
            }

            public void assignCredits(){
                c1 = Float.parseFloat(credit1.getSelectedItem().toString());
                c2 = Float.parseFloat(credit2.getSelectedItem().toString());
                c3 = Float.parseFloat(credit3.getSelectedItem().toString());
                c4 = Float.parseFloat(credit4.getSelectedItem().toString());
                c5 = Float.parseFloat(credit5.getSelectedItem().toString());
                c6 = Float.parseFloat(credit6.getSelectedItem().toString());
            }
        });

    }
}
