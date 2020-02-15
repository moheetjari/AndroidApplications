package com.example.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        details = findViewById(R.id.txtDetails);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("Firstname");
        String lastName = intent.getStringExtra("Lastname");
        details.setText("Welcome " + firstName + " " + lastName);
    }
}
