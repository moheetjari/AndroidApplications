package com.example.program10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Employee.db";
    private static final String EMPLOYEE_TABLE_NAME = "employees";
    private static final String EMPLOYEE_COLUMN_ID = "id";
    private static final String EMPLOYEE_COLUMN_NAME = "name";
    private static final String EMPLOYEE_COLUMN_DEPT = "dept";
    private static final String EMPLOYEE_COLUMN_SALARY = "salary";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + EMPLOYEE_TABLE_NAME +
                "(" + EMPLOYEE_COLUMN_ID + " INTEGER PRIMARY KEY," + EMPLOYEE_COLUMN_NAME + " TEXT," + EMPLOYEE_COLUMN_DEPT + " TEXT," + EMPLOYEE_COLUMN_SALARY + " DOUBLE)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME);
        onCreate(db);
    }

    public boolean addEmployee(String name, String dept, Double salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("dept", dept);
        values.put("salary", salary);
        long i=db.insert(EMPLOYEE_TABLE_NAME, null, values);
        if(i>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Cursor getEmployee(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + EMPLOYEE_TABLE_NAME + " WHERE " + EMPLOYEE_COLUMN_ID + " = " + id, null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, EMPLOYEE_TABLE_NAME);
        return numRows;
    }

    public boolean updateEmployee(Integer id, String name, String dept, Double salary) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("dept", dept);
        values.put("salary", salary);
        db.update(EMPLOYEE_TABLE_NAME, values, EMPLOYEE_COLUMN_ID + " = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public boolean deleteEmployee(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(EMPLOYEE_TABLE_NAME, EMPLOYEE_COLUMN_ID + " = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public ArrayList<String> getAllEmployees() {
        ArrayList<String> arrayList = new ArrayList<String>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + EMPLOYEE_TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            arrayList.add(res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_NAME)));
            res.moveToNext();
        }
        return arrayList;
    }
}
