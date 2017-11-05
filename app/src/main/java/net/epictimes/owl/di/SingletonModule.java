package net.epictimes.owl.di;

import net.epictimes.owl.OwlApplication;
import net.epictimes.owl.util.ActivityUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SingletonModule {

    @IsTablet
    @Singleton
    @Provides
    static boolean provideIsTablet(OwlApplication owlApplication) {
        return ActivityUtils.isTablet(owlApplication);
    }

}
