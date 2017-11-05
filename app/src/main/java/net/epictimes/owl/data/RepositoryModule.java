package net.epictimes.owl.data;

import net.epictimes.owl.data.local.LocalDataSource;
import net.epictimes.owl.data.remote.RemoteDataSource;

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
