package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Room;

import net.epictimes.chameleon.ChameleonApplication;
import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.util.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {

    @LocalDataSource
    @Singleton
    @Provides
    PhotoDataSource provideLocalDataSource(AppExecutors appExecutors, PhotoDao photoDao) {
        return new PhotoLocalDataSource(appExecutors, photoDao);
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
    PhotoDao providePhotoDao(ChameleonDatabase chameleonDatabase) {
        return chameleonDatabase.photoDao();
    }

}
