package com.example.program10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText EmpName, EmpSalary;
    Spinner EmpDept;
    Button BtnAdd, BtnView;
    String[] Department = {"HR", "Sales", "IT"};
    DBHelper Empdb;
    ListView lstView;
    CustomAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Empdb = new DBHelper(MainActivity.this);
        EmpName = (EditText) findViewById(R.id.EmpName);
        EmpSalary = (EditText) findViewById(R.id.EmpSalary);
        EmpDept = (Spinner) findViewById(R.id.EmpDept);
        BtnAdd = (Button) findViewById(R.id.BtnAdd);
        BtnView = (Button) findViewById(R.id.BtnView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Department);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        EmpDept.setAdapter(arrayAdapter);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = EmpName.getText().toString();
                String dept = EmpDept.getSelectedItem().toString();
                Double salary = Double.valueOf(EmpSalary.getText().toString());

                Empdb.addEmployee(name, dept, salary);
            }
        });

        BtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmpList.class);
                startActivity(intent);
            }
        });
    }
}
