package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ColumnInfo.INTEGER;
import static android.arch.persistence.room.ColumnInfo.REAL;
import static android.arch.persistence.room.ColumnInfo.TEXT;
import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "table_car",
        foreignKeys = @ForeignKey(entity = Employee.class, parentColumns = "id",
                childColumns = "employee_id", onDelete = CASCADE))
public class Car {

    public Car(long id, String model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "model_name")
    private String model;

    //@ColumnInfo(typeAffinity = TEXT)
    public int year;

    @ColumnInfo(name = "employee_id")
    public long employeeId;

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
