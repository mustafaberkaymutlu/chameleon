package net.epictimes.owl.di;

import net.epictimes.owl.features.detail.TweetDetailActivity;
import net.epictimes.owl.features.detail.TweetDetailActivityModule;
import net.epictimes.owl.features.login.LoginActivity;
import net.epictimes.owl.features.login.LoginActivityModule;
import net.epictimes.owl.features.timeline.TimelineActivity;
import net.epictimes.owl.features.timeline.TimelineActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TimelineActivityModule.class})
    abstract TimelineActivity contributeMainActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TweetDetailActivityModule.class})
    abstract TweetDetailActivity contributeTweetDetailActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity contributeLoginActivityInjector();

}
