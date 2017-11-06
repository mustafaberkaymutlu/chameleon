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
    TweetsRepository provideTweetsRepository(@RemoteDataSource TweetsDataSource remoteDataSource,
                                             @LocalDataSource TweetsDataSource localDataSource) {
        return new TweetsRepository(remoteDataSource, localDataSource);
    }

    @Singleton
    @Provides
    UsersRepository provideUsersRepository(@LocalDataSource UsersDataSource localDataSource) {
        return new UsersRepository(localDataSource);
    }

}
