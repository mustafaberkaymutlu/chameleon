package net.epictimes.chameleon.di;

import net.epictimes.chameleon.OwlApplication;
import net.epictimes.chameleon.util.ActivityUtils;
import net.epictimes.chameleon.util.AppExecutors;

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
