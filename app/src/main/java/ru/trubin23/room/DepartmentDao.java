package ru.trubin23.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DepartmentDao {

    @Query("SELECT id, name FROM department")
    List<DepartmentWithEmployees> getDepartmentWithEmployees();

}
