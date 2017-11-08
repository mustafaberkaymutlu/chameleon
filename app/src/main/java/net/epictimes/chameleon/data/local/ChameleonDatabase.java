package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import net.epictimes.chameleon.data.model.Photo;

@TypeConverters({DateTypeConverter.class, UserTypeConverter.class})
@Database(entities = {Photo.class}, version = 1)
abstract class ChameleonDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "chameleon-db";

    abstract PhotoDao photoDao();

}
