package com.example.exam6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumber1 = findViewById(R.id.etNumber1);
        EditText etNumber2 = findViewById(R.id.etNumber2);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(view -> {
            String number1Str = etNumber1.getText().toString().trim();
            String number2Str = etNumber2.getText().toString().trim();

            if (number1Str.isEmpty() || number2Str.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            int number1 = Integer.parseInt(number1Str);
            int number2 = Integer.parseInt(number2Str);

            if (number1 < 1 || number1 > 100 || number2 < 1 || number2 > 100) {
                Toast.makeText(this, "Numbers must be in the range 1 to 100", Toast.LENGTH_SHORT).show();
                return;
            }

            int sum = number1 + number2;

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("sum", sum);
            startActivity(intent);
        });
    }
}
