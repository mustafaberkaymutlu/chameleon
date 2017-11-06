package net.epictimes.chameleon.di;

import net.epictimes.chameleon.features.detail.PhotoDetailActivity;
import net.epictimes.chameleon.features.detail.PhotoDetailActivityModule;
import net.epictimes.chameleon.features.list.PhotoListActivity;
import net.epictimes.chameleon.features.list.PhotoListActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {PhotoListActivityModule.class})
    abstract PhotoListActivity contributeMainActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {PhotoDetailActivityModule.class})
    abstract PhotoDetailActivity contributeTweetDetailActivityInjector();

}
