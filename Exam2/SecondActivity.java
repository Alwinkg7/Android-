package com.example.exam2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView bookDetailsTextView = findViewById(R.id.bookDetailsTextView);

        String name = getIntent().getStringExtra("NAME");
        String price = getIntent().getStringExtra("PRICE");
        String author = getIntent().getStringExtra("AUTHOR");
        String description = getIntent().getStringExtra("DESCRIPTION");

        bookDetailsTextView.setText(
                "Book: " + name + "\n" +
                        "Price: " + price + "\n" +
                        "Author: " + author + "\n" +
                        "Description: " + description
        );
    }
}
