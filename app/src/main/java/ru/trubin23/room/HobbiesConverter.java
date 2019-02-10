package ru.trubin23.room;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;

public class HobbiesConverter {

    @TypeConverter
    public String fromHobbies(List<String> hobbies) {
        return TextUtils.join(",", hobbies);
    }

    @TypeConverter
    public List<String> toHobbies(String data) {
        return Arrays.asList(data.split(","));
    }
}
