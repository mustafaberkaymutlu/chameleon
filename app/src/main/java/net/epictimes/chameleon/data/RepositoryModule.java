package net.epictimes.chameleon.data;

import net.epictimes.chameleon.data.local.LocalDataSource;
import net.epictimes.chameleon.data.remote.RemoteDataSource;

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

    @Singleton
    @Provides
    UserRepository provideUsersRepository(@LocalDataSource UserDataSource localDataSource) {
        return new UserRepository(localDataSource);
    }

}
