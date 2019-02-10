package ru.trubin23.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.List;

@Dao
public interface DepartmentDao {

    @Transaction
    @Query("SELECT id, name FROM department")
    List<DepartmentWithStudents> getDepartmentWithEmployees();

    @Transaction
    @Query("SELECT * FROM department")
    List<DepartmentWithSelectStudents> getDepartmentWithSelectStudents();

}
