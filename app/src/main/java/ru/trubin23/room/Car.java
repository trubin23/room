package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ColumnInfo.TEXT;

@Entity(tableName = "table_car",
        foreignKeys = @ForeignKey(entity = Employee.class, parentColumns = "id", childColumns = "employee_id"))
public class Car {

    public Car(long id, String model, int year){
        this.id = id;
        this.model = model;
        this.year = year;
    }

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "model_name")
    private String model;

    @ColumnInfo(typeAffinity = TEXT)
    private int year;

    @ColumnInfo(name = "employee_id")
    private long employeeId;

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public long getEmployeeId() {
        return employeeId;
    }
}
