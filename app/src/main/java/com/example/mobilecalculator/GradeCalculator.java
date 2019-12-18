package com.example.mobilecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GradeCalculator extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_grade_calculator);
    }
    public void BackButton1(View back1){
        startActivity(new Intent(GradeCalculator.this, MainActivity.class));
    }
}
