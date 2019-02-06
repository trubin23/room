package ru.trubin23.room;

import android.arch.persistence.room.TypeConverter;

public class DateConverter {

    @TypeConverter
    public static String toYearString(int year) {
        return String.valueOf(year);
    }

    @TypeConverter
    public static int toYear(String yearString) {
        return Integer.parseInt(yearString);
    }
}
