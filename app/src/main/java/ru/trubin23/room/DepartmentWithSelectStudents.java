package ru.trubin23.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class DepartmentWithSelectStudents {

    @Embedded
    public Department department;

    @Relation(parentColumn = "id", entityColumn = "department_id", entity = Student.class)
    public List<StudentNameAndSalary> students;

}
