package com.example.exam8;



import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvStudentIDCard = findViewById(R.id.tvStudentIDCard);
        TextView tvIDCardDetails = findViewById(R.id.tvIDCardDetails);

        // Retrieve data passed from MainActivity
        String admissionNumber = getIntent().getStringExtra("admissionNumber");
        String name = getIntent().getStringExtra("name");
        String course = getIntent().getStringExtra("course");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Display the student ID card details
        String idCardDetails = "Admission Number: " + admissionNumber + "\n" +
                "Name: " + name + "\n" +
                "Course: " + course + "\n" +
                "Phone Number: " + phoneNumber;

        tvIDCardDetails.setText(idCardDetails);
    }
}

