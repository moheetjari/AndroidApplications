package com.example.program10;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class EmployeeAdapter extends ArrayAdapter<Employee> {


    public EmployeeAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
