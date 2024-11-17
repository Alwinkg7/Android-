package com.example.exam1;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MarksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);

        EditText etMark1 = findViewById(R.id.etMark1);
        EditText etMark2 = findViewById(R.id.etMark2);
        EditText etMark3 = findViewById(R.id.etMark3);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            try {
                int mark1 = Integer.parseInt(etMark1.getText().toString().trim());
                int mark2 = Integer.parseInt(etMark2.getText().toString().trim());
                int mark3 = Integer.parseInt(etMark3.getText().toString().trim());
                int total = mark1 + mark2 + mark3;
                double percentage = (total / 3.0);

                tvResult.setText("Percentage: " + percentage + "%");
            } catch (NumberFormatException e) {
                tvResult.setText("Please enter valid marks!");
            }
        });
    }
}
