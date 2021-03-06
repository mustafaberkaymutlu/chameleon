package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.di.scope.ActivityScoped;
import net.epictimes.chameleon.di.scope.FragmentScoped;
import net.epictimes.chameleon.features.list.PhotoListTabletPresenter;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PhotoDetailActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = PhotoDetailFragmentModule.class)
    abstract PhotoDetailFragment contributePhotoDetailFragmentInjector();

    @ActivityScoped
    @Provides
    static PhotoListTabletPresenter providePhotoListTabletPresenter() {
        return new PhotoListTabletPresenter();
    }

}
