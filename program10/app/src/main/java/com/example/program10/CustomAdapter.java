package com.example.program10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<Employee> employeeList;
    Context mCtx;

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
        Employee employee = employeeList.get(position);

        //getting view
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDept = convertView.findViewById(R.id.txtDept);
        TextView txtSalary = convertView.findViewById(R.id.txtSalary);

        //adding data to views
        txtName.setText(employee.getName());
        txtDept.setText(employee.getDept());
        txtSalary.setText(String.valueOf(employee.getSalary()));

        return convertView;
    }
}
