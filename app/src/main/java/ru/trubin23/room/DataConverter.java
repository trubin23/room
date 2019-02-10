package ru.trubin23.room;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DataConverter {

    @TypeConverter
    public Long dataToTimestamp(Date date) {
        if (date != null) {
            return date.getTime();
        } else {
            return null;
        }
    }
}
