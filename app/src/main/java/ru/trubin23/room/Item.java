package ru.trubin23.room;


import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"key1", "key2"})
public class Item {

    public long key1;
    public long key2;
}
