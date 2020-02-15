package com.example.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtFirst, txtLast;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFirst = findViewById(R.id.txtFirstname);
        txtLast = findViewById(R.id.txtLastname);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity2();
            }
        });
    }

    public void startActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Firstname", txtFirst.getText().toString());
        intent.putExtra("Lastname", txtLast.getText().toString());
        startActivity(intent);
    }
}
