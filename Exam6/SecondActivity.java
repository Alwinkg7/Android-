package com.example.exam6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvSumResult = findViewById(R.id.tvSumResult);

        int sum = getIntent().getIntExtra("sum", 0);
        tvSumResult.setText("The sum of the numbers is: " + sum);
    }
}
