package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getData = findViewById(R.id.getData);

        SharedPreferences sharedPreferences = getSharedPreferences("registerDetails", MODE_PRIVATE);
        String Name = sharedPreferences.getString("name", "");
        String Address = sharedPreferences.getString("address", "");
        String city = sharedPreferences.getString("city", "");
        String Phone = sharedPreferences.getString("phone", "");
        String Gender = sharedPreferences.getString("gender", "");

        getData.setText(Name + " " + Address + " " + city + " " + Phone + " " + Gender);
    }
}
