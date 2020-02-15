package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAddress, editCity, editPhone;
    RadioButton rdoMale, rdoFemale;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        editCity = findViewById(R.id.editCity);
        editPhone = findViewById(R.id.editPhone);
        btnRegister = findViewById(R.id.btnRegister);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("registerDetails", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("name", editName.getText().toString());
                myEdit.putString("address", editAddress.getText().toString());
                myEdit.putString("city", editCity.getText().toString());
                myEdit.putString("phone", editPhone.getText().toString());
                if (rdoMale.isChecked()) {
                    myEdit.putString("gender", rdoMale.getText().toString());
                }
                if (rdoFemale.isChecked()) {
                    myEdit.putString("gender", rdoFemale.getText().toString());
                }
                myEdit.commit();
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
