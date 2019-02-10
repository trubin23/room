package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import java.util.List;

@Entity(indices = {
        @Index("salary"),
        @Index(value = {"first_name", "last_name"}, unique = true)
})
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    public int salary;

    @ColumnInfo(index = true)
    public int age;

    @Embedded(prefix = "address")
    public Address address;

    @Ignore
    public Bitmap avatar;

    @Override
    public String toString() {
        return "id = " + String.valueOf(id) + " ; " +
                "firstName = " + firstName + " ; " +
                "lastName = " + lastName + " ; " +
                "salary = " + String.valueOf(salary) + " ; " +
                "age = " + String.valueOf(age) + " ; " +
                "address.city = " + address.city + " ; " +
                "address.street = " + address.street + " ; " +
                "address.number = " + address.number;
    }
}
