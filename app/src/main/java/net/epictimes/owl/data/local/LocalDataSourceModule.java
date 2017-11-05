package net.epictimes.owl.data.local;

import android.arch.persistence.room.Room;

import net.epictimes.owl.OwlApplication;
import net.epictimes.owl.data.TweetsDataSource;
import net.epictimes.owl.data.UsersDataSource;
import net.epictimes.owl.util.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {

    @LocalDataSource
    @Singleton
    @Provides
    UsersDataSource provideUsersDataSource(UserDao userDao, AppExecutors appExecutors) {
        return new UsersLocalDataSource(userDao, appExecutors);
    }

    @LocalDataSource
    @Singleton
    @Provides
    TweetsDataSource provideLocalDataSource(AppExecutors appExecutors, TweetDao tweetDao) {
        return new TweetsLocalDataSource(appExecutors, tweetDao);
    }

    @Singleton
    @Provides
    OwlDatabase provideOwlDatabase(OwlApplication owlApplication) {
        return Room.databaseBuilder(owlApplication,
                OwlDatabase.class, OwlDatabase.DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    UserDao provideUserDao(OwlDatabase owlDatabase) {
        return owlDatabase.userDao();
    }

    @Singleton
    @Provides
    TweetDao provideTweetDao(OwlDatabase owlDatabase) {
        return owlDatabase.tweetsDao();
    }

}
