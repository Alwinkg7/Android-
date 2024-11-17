package com.example.exam7;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText etNumber1 = findViewById(R.id.etNumber1);
        EditText etNumber2 = findViewById(R.id.etNumber2);
        EditText etNumber3 = findViewById(R.id.etNumber3);
        Button btnFindSmallest = findViewById(R.id.btnFindSmallest);
        TextView tvResult = findViewById(R.id.tvSmallestDivisibleBy5);

        btnFindSmallest.setOnClickListener(view -> {
            int number1 = Integer.parseInt(etNumber1.getText().toString().trim());
            int number2 = Integer.parseInt(etNumber2.getText().toString().trim());
            int number3 = Integer.parseInt(etNumber3.getText().toString().trim());

            int result = findSmallestDivisibleBy5(number1, number2, number3);
            if (result == -1) {
                tvResult.setText("No number divisible by 5 found.");
            } else {
                tvResult.setText("Smallest number divisible by 5: " + result);
            }
        });
    }

    private int findSmallestDivisibleBy5(int num1, int num2, int num3) {
        int smallest = -1;

        // Check if num1 is divisible by 5
        if (num1 % 5 == 0) {
            smallest = num1;
        }
        // Check if num2 is divisible by 5 and smaller than the current smallest
        if (num2 % 5 == 0 && (smallest == -1 || num2 < smallest)) {
            smallest = num2;
        }
        // Check if num3 is divisible by 5 and smaller than the current smallest
        if (num3 % 5 == 0 && (smallest == -1 || num3 < smallest)) {
            smallest = num3;
        }

        return smallest;
    }
}

