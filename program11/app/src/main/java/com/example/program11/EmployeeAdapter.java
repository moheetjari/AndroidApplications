package com.example.program11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    Context context;
    int resource;
    ArrayList<Employee> employees;

    public EmployeeAdapter(Context context, int resource, ArrayList<Employee> employees) {
        this.context = context;
        this.resource = resource;
        this.employees = employees;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView dept;
        TextView salary;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.txtid);
            name = (TextView) itemView.findViewById(R.id.txtname);
            dept = (TextView) itemView.findViewById(R.id.txtdept);
            salary = (TextView) itemView.findViewById(R.id.txtsalary);
            btnEdit = (Button) itemView.findViewById(R.id.btnedit);
            btnDelete = (Button) itemView.findViewById(R.id.btndelete);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.id.setText(String.valueOf(employee.getId()));
        holder.name.setText(employee.getName());
        holder.dept.setText(employee.getDept());
        holder.salary.setText(String.valueOf(employee.getSalary()));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
