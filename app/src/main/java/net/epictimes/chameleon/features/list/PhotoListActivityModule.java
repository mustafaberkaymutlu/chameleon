package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.di.scope.ActivityScoped;
import net.epictimes.chameleon.di.scope.FragmentScoped;
import net.epictimes.chameleon.features.detail.PhotoDetailFragment;
import net.epictimes.chameleon.features.detail.PhotoDetailFragmentModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PhotoListActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = PhotoListFragmentModule.class)
    abstract PhotoListFragment contributePhotoListFragmentInjector();

    @FragmentScoped
    @ContributesAndroidInjector(modules = PhotoDetailFragmentModule.class)
    abstract PhotoDetailFragment contributePhotoDetailFragmentInjector();

    @ActivityScoped
    @Provides
    static PhotoListTabletPresenter providePhotoListTabletPresenter() {
        return new PhotoListTabletPresenter();
    }

}
