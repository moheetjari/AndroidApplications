package com.example.program10;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<Employee> employeeList;
    Context mCtx;
    DBHelper Empdb;

    public CustomAdapter(Context mCtx, List<Employee> employeeList) {
        this.mCtx = mCtx;
        this.employeeList = employeeList;
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(mCtx.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_item, null);
        //getting employee of the specified position
        final Employee employee = employeeList.get(position);

        //getting view
        final TextView txtid = convertView.findViewById(R.id.txtid);
        final TextView txtName = convertView.findViewById(R.id.txtName);
        final TextView txtDept = convertView.findViewById(R.id.txtDept);
        final TextView txtSalary = convertView.findViewById(R.id.txtSalary);
        Button btnUpdate = convertView.findViewById(R.id.btnEdit);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);

        //adding data to views
        txtid.setText(String.valueOf(employee.getId()));
        txtName.setText(employee.getName());
        txtDept.setText(employee.getDept());
        txtSalary.setText(String.valueOf(employee.getSalary()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(mCtx);
                dialog.setContentView(R.layout.edit_dialog);
                dialog.setTitle("Update Employee");

                String[] Department = {"HR", "Sales", "IT"};
                final EditText empId = dialog.findViewById(R.id.Empid);
                final EditText empName = dialog.findViewById(R.id.EmpName);
                final Spinner dept = dialog.findViewById(R.id.EmpDept);
                final EditText empSalary = dialog.findViewById(R.id.EmpSalary);
                final Button btnUemp = dialog.findViewById(R.id.BtnUpdate);


                empId.setText(String.valueOf(txtid.getText()));
                empName.setText(txtName.getText().toString());
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mCtx, android.R.layout.simple_spinner_dropdown_item, Department);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dept.setAdapter(arrayAdapter);
                empSalary.setText(String.valueOf(txtSalary.getText()));

                btnUemp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = Integer.parseInt(empId.getText().toString());
                        String name = empName.getText().toString();
                        int salary = Integer.parseInt(empSalary.getText().toString());

                        Empdb = new DBHelper(mCtx);
                        Empdb.updateEmployee(id, name, salary);
                        Toast.makeText(mCtx, "Employee Updated", Toast.LENGTH_SHORT).show();
                        Empdb.getAllEmployee();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        int id = Integer.parseInt(txtid.getText().toString());
                        System.out.println(id);
                        Empdb = new DBHelper(mCtx);
                        Empdb.deleteEmployee(id);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mCtx, "you clicked cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return convertView;
    }
}
