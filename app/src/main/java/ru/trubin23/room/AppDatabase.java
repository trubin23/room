package ru.trubin23.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Employee.class, Car.class, Student.class, Department.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    public abstract CarDao carDao();

    public abstract StudentDao studentDao();
}
