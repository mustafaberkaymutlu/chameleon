package net.epictimes.owl.di;

import net.epictimes.owl.OwlApplication;
import net.epictimes.owl.util.ActivityUtils;
import net.epictimes.owl.util.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SingletonModule {

    @IsTablet
    @Singleton
    @Provides
    boolean provideIsTablet(OwlApplication owlApplication) {
        return ActivityUtils.isTablet(owlApplication);
    }

    @Singleton
    @Provides
    AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }


}
