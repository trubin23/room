package ru.trubin23.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Transaction;

@Dao
public abstract class EmployeeCarDao {

    @Insert
    public abstract void insertEmployee(Employee employee);

    @Insert
    public abstract void insertCar(Car car);

    @Transaction
    public void insertCarAndEmployee(Car car, Employee employee) {
        insertCar(car);
        insertEmployee(employee);
    }
}
