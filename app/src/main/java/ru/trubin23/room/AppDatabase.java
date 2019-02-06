package ru.trubin23.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Employee.class, Car.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ru.trubin23.room.EmployeeDao employeeDao();

    public abstract ru.trubin23.room.CarDao carDao();
}
