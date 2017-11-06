package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Room;

import net.epictimes.chameleon.ChameleonApplication;
import net.epictimes.chameleon.data.TweetsDataSource;
import net.epictimes.chameleon.data.UsersDataSource;
import net.epictimes.chameleon.util.AppExecutors;

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
    ChameleonDatabase provideChameleonDatabase(ChameleonApplication chameleonApplication) {
        return Room.databaseBuilder(chameleonApplication,
                ChameleonDatabase.class, ChameleonDatabase.DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    UserDao provideUserDao(ChameleonDatabase chameleonDatabase) {
        return chameleonDatabase.userDao();
    }

    @Singleton
    @Provides
    TweetDao provideTweetDao(ChameleonDatabase chameleonDatabase) {
        return chameleonDatabase.tweetsDao();
    }

}
