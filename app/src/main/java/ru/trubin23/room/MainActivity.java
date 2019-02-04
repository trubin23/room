package ru.trubin23.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void testQueries() {
        AppDatabase database = App.getInstance().getDatabase();
        EmployeeDao employeeDao = database.employeeDao();

        Employee johnEmployee = new Employee();
        johnEmployee.id = 1;
        johnEmployee.name = "John";
        johnEmployee.salary = 10000;

        Employee bobEmployee = new Employee();
        bobEmployee.id = 2;
        bobEmployee.name = "Bob";
        bobEmployee.salary = 20000;

        for (Employee employee : employeeDao.getAll()) {
            Log.d(TAG, employee.toString());
            employeeDao.delete(employee);
        }

        employeeDao.insert(johnEmployee);
        employeeDao.insert(bobEmployee);

        for (Employee employee : employeeDao.getAll()) {
            Log.d(TAG, employee.toString());
        }

        Log.d(TAG, employeeDao.getById(johnEmployee.id).toString());

        bobEmployee.salary = 50000;
        employeeDao.update(bobEmployee);

        Log.d(TAG, employeeDao.getById(bobEmployee.id).toString());

        employeeDao.delete(johnEmployee);

        for (Employee employee : employeeDao.getAll()) {
            Log.d(TAG, employee.toString());
        }
    }
}
