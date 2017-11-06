package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.di.ActivityScoped;
import net.epictimes.chameleon.di.FragmentScoped;
import net.epictimes.chameleon.features.detail.PhotoDetailFragment;
import net.epictimes.chameleon.features.detail.PhotoDetailFragmentModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PhotoListActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = PhotoListFragmentModule.class)
    abstract PhotoListFragment contributeTimelineFragmentInjector();

    @FragmentScoped
    @ContributesAndroidInjector(modules = PhotoDetailFragmentModule.class)
    abstract PhotoDetailFragment contributeTweetDetailFragmentInjector();

    @ActivityScoped
    @Provides
    static PhotoListTabletPresenter provideTimelineTabletPresenter() {
        return new PhotoListTabletPresenter();
    }

}