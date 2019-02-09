package ru.trubin23.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    //@Query("SELECT student.name, student.salary, department.name AS department_name " +
    //        "FROM student, department " +
    //        "WHERE department.id == student.department_id")
    //public List<StudentDepartment> getStudentWithDepartment();
}
