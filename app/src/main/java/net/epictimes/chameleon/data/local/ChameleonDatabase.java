package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.data.model.User;

@Database(entities = {User.class, Photo.class}, version = 1)
abstract class ChameleonDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "chameleon-db";

    abstract PhotoDao photoDao();

}
