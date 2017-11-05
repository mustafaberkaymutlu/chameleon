package net.epictimes.owl.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import net.epictimes.owl.data.model.Tweet;
import net.epictimes.owl.data.model.User;

@Database(entities = {User.class, Tweet.class}, version = 1)
public abstract class OwlDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "owl-db";

    public abstract UserDao userDao();

    public abstract TweetDao tweetsDao();

}
