package com.example.exam1;

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
        EditText etusername = findViewById(R.id.etUsername);
        EditText etpassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v ->
                {
                        String username = etusername.getText().toString().trim();
                        String password = etpassword.getText().toString().trim();
                        if (username.equals("admin") && password.equals("password")) {
                            Intent intent = new Intent(MainActivity.this, MarksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}