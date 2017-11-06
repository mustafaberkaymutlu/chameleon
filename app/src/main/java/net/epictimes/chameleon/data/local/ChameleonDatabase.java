package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.data.model.User;

@Database(entities = {User.class, Photo.class}, version = 1)
public abstract class ChameleonDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "chameleon-db";

    public abstract UserDao userDao();

    public abstract PhotoDao photoDao();

}
