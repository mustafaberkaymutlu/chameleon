package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import net.epictimes.chameleon.data.model.User;

public class UserTypeConverter {

    @TypeConverter
    public static User toUser(String value) {
        return new Gson().fromJson(value, User.class);
    }

    @TypeConverter
    public static String toString(User value) {
        return new Gson().toJson(value);
    }

}
