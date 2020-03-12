package com.example.program10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmpList extends AppCompatActivity {
    ArrayList<Employee> employees;
    DBHelper Empdb;
    CustomAdapter adapter;
    ListView lstView;
    Button btnEdit, btnDelete;
    TextView EmpId, EmpName, EmpDept, EmpSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        EmpId = (TextView) findViewById(R.id.txtid);
        EmpName = (TextView) findViewById(R.id.txtName);
        EmpDept = (TextView) findViewById(R.id.txtDept);
        EmpSalary = (TextView) findViewById(R.id.txtSalary);

        Empdb = new DBHelper(EmpList.this);
        employees = Empdb.getAllEmployee();

        adapter = new CustomAdapter(this, employees);
        lstView = (ListView) findViewById(R.id.listView);
        lstView.setAdapter(adapter);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(EmpList.this);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
