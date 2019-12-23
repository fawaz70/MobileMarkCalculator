package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GPACalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);
        Spinner credit1 = (Spinner) findViewById(R.id.credit1);
        Spinner credit2 = (Spinner) findViewById(R.id.credit2);
        Spinner credit3 = (Spinner) findViewById(R.id.credit3);
        Spinner credit4 = (Spinner) findViewById(R.id.credit4);
        Spinner credit5 = (Spinner) findViewById(R.id.credit5);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(GPACalculator.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.credits));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        credit1.setAdapter(myAdapter); credit2.setAdapter(myAdapter); credit3.setAdapter(myAdapter);
        credit4.setAdapter(myAdapter); credit5.setAdapter(myAdapter);
    }
}
