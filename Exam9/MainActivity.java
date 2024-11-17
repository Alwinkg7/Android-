package com.example.exam9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etNum1, etNum2, etNum3;
    Button btnLogin;

    // Hardcoded admin credentials
    String validUsername = "admin";
    String validPassword = "admin123";  // Change this to your desired password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String num1Str = etNum1.getText().toString();
            String num2Str = etNum2.getText().toString();
            String num3Str = etNum3.getText().toString();

            // Validate user input
            if (!username.isEmpty() && !password.isEmpty() && !num1Str.isEmpty() && !num2Str.isEmpty() && !num3Str.isEmpty()) {

                // Check if credentials are correct
                if (username.equals(validUsername) && password.equals(validPassword)) {
                    try {
                        // Convert input strings to integers
                        int num1 = Integer.parseInt(num1Str);
                        int num2 = Integer.parseInt(num2Str);
                        int num3 = Integer.parseInt(num3Str);

                        // Pass the data to SecondActivity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("num1", num1);
                        intent.putExtra("num2", num2);
                        intent.putExtra("num3", num3);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
