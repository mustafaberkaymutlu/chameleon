package net.epictimes.chameleon.data;

import net.epictimes.chameleon.di.doc.LocalDataSource;
import net.epictimes.chameleon.di.doc.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    PhotoRepository providePhotoRepository(@RemoteDataSource PhotoDataSource remoteDataSource,
                                           @LocalDataSource PhotoDataSource localDataSource) {
        return new PhotoRepository(remoteDataSource, localDataSource);
    }

}
