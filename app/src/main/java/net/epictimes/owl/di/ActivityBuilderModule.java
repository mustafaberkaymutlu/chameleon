package net.epictimes.owl.di;

import net.epictimes.owl.features.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivityInjector();

}
