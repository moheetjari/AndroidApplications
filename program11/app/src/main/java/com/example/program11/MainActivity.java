package com.example.program11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView noData;
    RecyclerView view;
    SwipeRefreshLayout refreshLayout;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    HttpHandler httpHandler;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noData = (TextView) findViewById(R.id.txtNodata);
        view = (RecyclerView) findViewById(R.id.recycleView);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);

        employeeAdapter = new EmployeeAdapter(MainActivity.this, R.layout.row_items, employees);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        view.setLayoutManager(layoutManager);

        try {
            new ServiceSync().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ServiceSync extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        protected void onPreExecute() {
            progressDialog = progressDialog.show(MainActivity.this, "Please Wait", "Loading..");
            progressDialog.setCancelable(true);
        }

        @Override
        protected String doInBackground(String... strings) {
            res = null;
            try {
                httpHandler = new HttpHandler();
                res = httpHandler.getdata("http://localhost/dbservices/display.php");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        }

        protected void onPostExecute(String res) {
            try {
                JSONArray jsonArray = new JSONArray(res.toString());
                if (jsonArray.length() == 0) {
                    noData.setVisibility(View.VISIBLE);
                    noData.setText("No Data Found");
                    view.setVisibility(View.GONE);
                    refreshLayout.setRefreshing(false);
                } else {
                    view.setVisibility(View.VISIBLE);
                    noData.setVisibility(View.GONE);
                    employees = new ArrayList<Employee>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Employee employee = new Employee(object.getInt("id"), object.getInt("salary"), object.getString("name"), object.getString("dept"));
                        employees.add(employee);

                        employeeAdapter = new EmployeeAdapter(MainActivity.this, R.layout.row_items, employees);
                        view.setAdapter(employeeAdapter);
                        refreshLayout.setRefreshing(false);
                    }
                    employeeAdapter.notifyDataSetChanged();
                }
                progressDialog.dismiss();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
