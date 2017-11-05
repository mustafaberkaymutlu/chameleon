package net.epictimes.owl.data.local;

import android.arch.persistence.room.Room;

import net.epictimes.owl.OwlApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {

    @Singleton
    @Provides
    OwlDatabase provideOwlDatabase(OwlApplication owlApplication) {
        return Room.databaseBuilder(owlApplication,
                OwlDatabase.class, OwlDatabase.DATABASE_NAME)
                .build();
    }

}
