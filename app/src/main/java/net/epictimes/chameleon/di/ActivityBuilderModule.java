package net.epictimes.chameleon.di;

import net.epictimes.chameleon.features.detail.TweetDetailActivity;
import net.epictimes.chameleon.features.detail.TweetDetailActivityModule;
import net.epictimes.chameleon.features.timeline.TimelineActivity;
import net.epictimes.chameleon.features.timeline.TimelineActivityModule;

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

}
