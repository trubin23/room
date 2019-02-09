package ru.trubin23.room;

import android.arch.persistence.room.Relation;

import java.util.List;

public class DepartmentWithEmployees {

    public int id;

    public String name;

    @Relation(parentColumn = "id", entityColumn = "department_id")
    public List<Employee> employees;
}
