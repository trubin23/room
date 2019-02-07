package ru.trubin23.room;

import android.arch.persistence.room.ColumnInfo;

public class Name {

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "second_name")
    public String secondName;
}
