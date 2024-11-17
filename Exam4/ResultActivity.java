package com.example.exam4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvResult = findViewById(R.id.tvResult);

        double addition = getIntent().getDoubleExtra("addition", 0);
        double subtraction = getIntent().getDoubleExtra("subtraction", 0);
        double multiplication = getIntent().getDoubleExtra("multiplication", 0);
        double division = getIntent().getDoubleExtra("division", 0);

        String resultMessage = "Results:\n" +
                "Addition: " + addition + "\n" +
                "Subtraction: " + subtraction + "\n" +
                "Multiplication: " + multiplication + "\n" +
                "Division: " + (division != 0 ? division : "Undefined (division by zero)");

        tvResult.setText(resultMessage);
    }
}
