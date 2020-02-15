package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCount;
    TextView txtCount;
    CheckBox rakesh, suresh, mukesh, harish;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCount = findViewById(R.id.btnCount);
        txtCount = findViewById(R.id.txtCount);
        rakesh = findViewById(R.id.Rakesh);
        suresh = findViewById(R.id.Suresh);
        mukesh = findViewById(R.id.Mukesh);
        harish = findViewById(R.id.Harish);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rakesh.isChecked()) {
                    count++;
                }
                if (suresh.isChecked()) {
                    count++;
                }
                if (mukesh.isChecked()) {
                    count++;
                }
                if (harish.isChecked()) {
                    count++;
                }
                txtCount.setText(String.valueOf(count) + " Checkbox is checked");
                count = 0;
            }
        });
    }
}
