package com.example.exam5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        ImageView ivGenderImage = findViewById(R.id.ivGenderImage);
        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);

        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");

        tvWelcomeMessage.setText("Welcome, " + name);

        if ("Male".equalsIgnoreCase(gender)) {
            ivGenderImage.setImageResource(R.drawable.male_image); // Replace with actual male image
        } else if ("Female".equalsIgnoreCase(gender)) {
            ivGenderImage.setImageResource(R.drawable.female_image); // Replace with actual female image
        }
    }
}
