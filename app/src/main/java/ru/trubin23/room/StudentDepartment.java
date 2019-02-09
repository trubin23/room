package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;

public class StudentDepartment {

    public String name;

    public int salary;

    @ColumnInfo(name = "department_name")
    public String departmentName;

}