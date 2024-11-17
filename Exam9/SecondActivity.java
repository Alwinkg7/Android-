package com.example.exam9;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvClosestPair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvClosestPair = findViewById(R.id.tvClosestPair);

        // Retrieve the numbers passed from MainActivity
        int num1 = getIntent().getIntExtra("num1", 0);
        int num2 = getIntent().getIntExtra("num2", 0);
        int num3 = getIntent().getIntExtra("num3", 0);

        // Calculate the closest pair
        String closestPair = calculateClosestPair(num1, num2, num3);

        // Display the result
        tvClosestPair.setText("Closest Pair: " + closestPair);
    }

    // Method to calculate the closest pair
    private String calculateClosestPair(int num1, int num2, int num3) {
        int[] numbers = {num1, num2, num3};
        String closestPair = "";

        // Sort the numbers to easily find the closest pair
        java.util.Arrays.sort(numbers);

        // The closest pair is the smallest difference between consecutive numbers
        if (Math.abs(numbers[1] - numbers[0]) <= Math.abs(numbers[2] - numbers[1])) {
            closestPair = numbers[0] + " and " + numbers[1];
        } else {
            closestPair = numbers[1] + " and " + numbers[2];
        }

        return closestPair;
    }
}
