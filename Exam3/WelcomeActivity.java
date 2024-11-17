package com.example.exam3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);

        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");

        String welcomeMessage = "Welcome, " + name ;
        tvWelcomeMessage.setText(welcomeMessage);
    }
}
