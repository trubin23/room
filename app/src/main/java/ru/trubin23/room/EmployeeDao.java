package ru.trubin23.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface EmployeeDao {

    //@Query("SELECT * FROM employee")
    //LiveData<List<Employee>> getAll();

    //@Query("SELECT * FROM employee")
    //List<Employee> getAll();

    //@Query("SELECT * FROM employee")
    //Employee[] getAll();

    //@Query("SELECT * FROM employee")
    //Cursor getAll();

    //@Query("SELECT * FROM employee WHERE id = :id")
    //Employee getById(long id);

    @Query("SELECT * FROM employee WHERE id = :id")
    Flowable<List<Employee>> getByIdAsList(long id);

    @Query("SELECT * FROM employee")
    Flowable<List<Employee>> getAll();

    @Query("SELECT * FROM employee WHERE id = :id")
    Flowable<Employee> getById(long id);

    @Query("SELECT * FROM employee WHERE salary = :minSalary")
    List<Employee> getAllWithSalaryMoreThan(int minSalary);

    @Query("SELECT * FROM employee WHERE salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> getAllWithSalaryBetween(int minSalary, int maxSalary);

    @Query("SELECT * FROM employee WHERE first_name LIKE :search OR last_name LIKE :search")
    List<Employee> getAllWithNameLike(String search);

    @Query("SELECT * FROM employee WHERE id IN (:idList)")
    List<Employee> getByIdList(List<Long> idList);

    @Query("SELECT first_name, last_name FROM employee")
    List<Name> getNames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Employee employee);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insert(Employee... employees);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insert(List<Employee> employees);

    @Update
    void update(Employee employee);

    @Update
    int update(List<Employee> employeeList);

    @Update
    int delete(List<Employee> employeeList);

    @Query("UPDATE employee SET salary = :newSalary WHERE id IN (:idList)")
    int updateSalaryByIdList(List<Long> idList, int newSalary);

    @Query("DELETE FROM employee")
    void deleteAll();

    @Delete
    void delete(Employee employee);

    @Query("DELETE FROM employee WHERE id IN (:idList)")
    int deleteByIdList(List<Long> idList);
}
