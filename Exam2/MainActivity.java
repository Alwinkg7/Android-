package com.example.exam2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int selectedPosition = -1; // To track the selected item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Book details: {Name, Price, Author, Description}
        String[][] books = {
                {"Book 1", "$10", "Author A", "This is a description of Book 1."},
                {"Book 2", "$15", "Author B", "This is a description of Book 2."},
                {"Book 3", "$20", "Author C", "This is a description of Book 3."}
        };

        ListView listView = findViewById(R.id.bookListView);
        Button viewDetailsButton = findViewById(R.id.viewDetailsButton);

        // Extract names and prices for displaying in the ListView
        String[] bookDisplay = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            bookDisplay[i] = books[i][0] + " - " + books[i][1];
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookDisplay) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;

                // Highlight the selected item
                if (position == selectedPosition) {
                    textView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    textView.setTextColor(getResources().getColor(android.R.color.white));
                } else {
                    textView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    textView.setTextColor(getResources().getColor(android.R.color.white));
                }
                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            selectedPosition = position; // Update the selected position
            adapter.notifyDataSetChanged(); // Refresh the list to apply highlighting
        });

        viewDetailsButton.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAME", books[selectedPosition][0]);
                intent.putExtra("PRICE", books[selectedPosition][1]);
                intent.putExtra("AUTHOR", books[selectedPosition][2]);
                intent.putExtra("DESCRIPTION", books[selectedPosition][3]);
                startActivity(intent);
            }
        });
    }
}
