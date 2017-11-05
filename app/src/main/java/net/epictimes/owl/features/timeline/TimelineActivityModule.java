package net.epictimes.owl.features.timeline;

import net.epictimes.owl.di.ActivityScoped;
import net.epictimes.owl.di.FragmentScoped;
import net.epictimes.owl.features.detail.TweetDetailFragment;
import net.epictimes.owl.features.detail.TweetDetailFragmentModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TimelineActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = TimelineFragmentModule.class)
    abstract TimelineFragment contributeTimelineFragmentInjector();

    @FragmentScoped
    @ContributesAndroidInjector(modules = TweetDetailFragmentModule.class)
    abstract TweetDetailFragment contributeTweetDetailFragmentInjector();

    @ActivityScoped
    @Provides
    static TimelineTabletPresenter provideTimelineTabletPresenter() {
        return new TimelineTabletPresenter();
    }

}
