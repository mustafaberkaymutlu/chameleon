package net.epictimes.owl.features.detail;

import net.epictimes.owl.di.ActivityScoped;
import net.epictimes.owl.di.FragmentScoped;
import net.epictimes.owl.features.timeline.TimelineTabletPresenter;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TweetDetailActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = TweetDetailFragmentModule.class)
    abstract TweetDetailFragment contributeTweetDetailFragmentInjector();

    @ActivityScoped
    @Provides
    static TimelineTabletPresenter provideTimelineTabletPresenter() {
        // TODO this should not be called, can be removed
        return new TimelineTabletPresenter();
    }

}
