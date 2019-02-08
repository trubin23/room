package ru.trubin23.room;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testQueries3();
    }

    private void testQueries3() {
        AppDatabase database = App.getInstance().getDatabase();
        EmployeeDao employeeDao = database.employeeDao();

        Employee johnEmployee = new Employee();
        johnEmployee.id = 1;
        johnEmployee.firstName = "John";
        johnEmployee.lastName = "Smith";
        johnEmployee.salary = 10000;
        johnEmployee.age = 25;
        Address johnAddress = new Address();
        johnAddress.city = "London";
        johnAddress.street = "Baker Street";
        johnAddress.number = 221;
        johnEmployee.address = johnAddress;

        Employee bobEmployee = new Employee();
        bobEmployee.id = 2;
        bobEmployee.firstName = "Bob";
        bobEmployee.lastName = "Johnson";
        bobEmployee.salary = 20000;
        bobEmployee.age = 26;
        Address bobAddress = new Address();
        bobAddress.city = "London";
        bobAddress.street = "Baker Street";
        bobAddress.number = 222;
        bobEmployee.address = bobAddress;

        employeeDao.deleteAll();

        employeeDao.insert(johnEmployee);
        employeeDao.insert(bobEmployee);

        employeeDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) {
                        for (Employee employee : employees) {
                            Log.d(TAG, employee.toString());
                        }
                    }
                });

        employeeDao.getById(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        Log.d(TAG, employee.toString());
                    }
                });

        employeeDao.getByIdAsList(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) {
                        Log.d(TAG, String.valueOf(employees.size()));
                    }
                });
    }

    private void testQueries2() {
        AppDatabase database = App.getInstance().getDatabase();
        EmployeeDao employeeDao = database.employeeDao();

        employeeDao.deleteAll();

        Employee johnEmployee = new Employee();
        johnEmployee.id = 1;
        johnEmployee.firstName = "John";
        johnEmployee.lastName = "Smith";
        johnEmployee.salary = 10000;
        johnEmployee.age = 25;
        Address address = new Address();
        address.city = "London";
        address.street = "Baker Street";
        address.number = 221;
        johnEmployee.address = address;
        johnEmployee.avatar = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground);

        employeeDao.insert(johnEmployee);

        employeeDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) {
                        for (Employee employee : employees) {
                            Log.d(TAG, employee.toString());
                        }
                    }
                });
    }

    private void testQueries() {
        AppDatabase database = App.getInstance().getDatabase();
        EmployeeDao employeeDao = database.employeeDao();

        Employee johnEmployee = new Employee();
        johnEmployee.id = 1;
        johnEmployee.firstName = "John";
        johnEmployee.lastName = "Smith";
        johnEmployee.salary = 10000;

        Employee bobEmployee = new Employee();
        bobEmployee.id = 2;
        bobEmployee.firstName = "Bob";
        bobEmployee.lastName = "Johnson";
        bobEmployee.salary = 20000;

        employeeDao.deleteAll();

        employeeDao.insert(johnEmployee);
        employeeDao.insert(bobEmployee);

        employeeDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) {
                        for (Employee employee : employees) {
                            Log.d(TAG, employee.toString());
                        }
                    }
                });

        Log.d(TAG, employeeDao.getById(johnEmployee.id).toString());

        bobEmployee.salary = 50000;
        employeeDao.update(bobEmployee);

        Log.d(TAG, employeeDao.getById(bobEmployee.id).toString());

        employeeDao.delete(johnEmployee);

        employeeDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) {
                        for (Employee employee : employees) {
                            Log.d(TAG, employee.toString());
                        }
                    }
                });
    }
}
