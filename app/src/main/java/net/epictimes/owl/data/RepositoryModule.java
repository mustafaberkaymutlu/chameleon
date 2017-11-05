package net.epictimes.owl.data;

import net.epictimes.owl.data.api.Services;
import net.epictimes.owl.data.local.LocalDataSource;
import net.epictimes.owl.data.remote.RemoteDataSource;
import net.epictimes.owl.data.remote.TweetsRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    @RemoteDataSource
    TweetsDataSource provideRemoteDataSource(Services services) {
        return new TweetsRemoteDataSource(services);
    }

    @Singleton
    @Provides
    @LocalDataSource
    TweetsDataSource provideLocalDataSource(Services services) {
        return new TweetsRemoteDataSource(services); // TODO change this
    }

    @Singleton
    @Provides
    TweetsRepository provideTweetsRepository(@RemoteDataSource TweetsDataSource remoteDataSource,
                                             @LocalDataSource TweetsDataSource localDataSource) {
        return new TweetsRepository(remoteDataSource, localDataSource);
    }

}
