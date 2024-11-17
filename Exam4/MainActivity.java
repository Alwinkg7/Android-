package com.example.exam4;

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

            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            double addition = number1 + number2;
            double subtraction = number1 - number2;
            double multiplication = number1 * number2;
            double division = number2 != 0 ? number1 / number2 : 0;

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("addition", addition);
            intent.putExtra("subtraction", subtraction);
            intent.putExtra("multiplication", multiplication);
            intent.putExtra("division", division);
            startActivity(intent);
        });
    }
}
