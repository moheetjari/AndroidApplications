package com.example.program10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmpList extends AppCompatActivity {
    ArrayList<Employee> employees;
    DBHelper Empdb;
    CustomAdapter adapter;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
        Empdb = new DBHelper(EmpList.this);
        employees = Empdb.getAllEmployee();

        for (Employee emp : employees) {
            System.out.println("name = " + emp.getName());
        }

        adapter = new CustomAdapter(this, employees);
        lstView = findViewById(R.id.listView);
        lstView.setAdapter(adapter);
    }
}
