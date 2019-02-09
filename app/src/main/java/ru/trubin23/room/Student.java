package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    public long id;

    public String name;

    public int salary;

    @ColumnInfo(name = "department_id")
    public int departmentId;

}
