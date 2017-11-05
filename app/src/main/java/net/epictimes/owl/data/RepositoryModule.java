package net.epictimes.owl.data;

import net.epictimes.owl.data.local.OwlDatabase;
import net.epictimes.owl.data.remote.Services;
import net.epictimes.owl.data.local.LocalDataSource;
import net.epictimes.owl.data.local.TweetsLocalDataSource;
import net.epictimes.owl.data.remote.RemoteDataSource;
import net.epictimes.owl.data.remote.TweetsRemoteDataSource;
import net.epictimes.owl.util.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @RemoteDataSource
    @Singleton
    @Provides
    TweetsDataSource provideRemoteDataSource(Services services) {
        return new TweetsRemoteDataSource(services);
    }

    @LocalDataSource
    @Singleton
    @Provides
    TweetsDataSource provideLocalDataSource(AppExecutors appExecutors, OwlDatabase owlDatabase) {
        return new TweetsLocalDataSource(appExecutors, owlDatabase.tweetsDao());
    }

    @Singleton
    @Provides
    TweetsRepository provideTweetsRepository(@RemoteDataSource TweetsDataSource remoteDataSource,
                                             @LocalDataSource TweetsDataSource localDataSource) {
        return new TweetsRepository(remoteDataSource, localDataSource);
    }

}
