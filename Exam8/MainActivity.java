package com.example.exam8;

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

        EditText etAdmissionNumber = findViewById(R.id.etAdmissionNumber);
        EditText etName = findViewById(R.id.etName);
        EditText etCourse = findViewById(R.id.etCourse);
        EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);
        Button btnGenerateID = findViewById(R.id.btnGenerateID);

        btnGenerateID.setOnClickListener(view -> {
            String admissionNumber = etAdmissionNumber.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String course = etCourse.getText().toString().trim();
            String phoneNumber = etPhoneNumber.getText().toString().trim();

            // Validate that the fields are not empty
            if (admissionNumber.isEmpty() || name.isEmpty() || course.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Proceed to SecondActivity to generate ID card
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("admissionNumber", admissionNumber);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("phoneNumber", phoneNumber);
            startActivity(intent);
        });
    }
}
