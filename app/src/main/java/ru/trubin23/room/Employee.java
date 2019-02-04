package ru.trubin23.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;

    public int salary;

    @Override
    public String toString() {
        return "id = " + String.valueOf(id) + " ; " +
                "name = " + name + " ; " +
                "salary = " + String.valueOf(salary);
    }
}
