package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.di.scope.FragmentScoped;
import net.epictimes.chameleon.di.doc.IsTablet;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoListFragmentModule {

    @FragmentScoped
    @Provides
    PhotoListPresenter providePresenterImpl(PhotoRepository photoRepository,
                                            PhotoListFragment photoListFragment) {
        return new PhotoListPresenter(photoListFragment, photoRepository);
    }

    @FragmentScoped
    @Provides
    PhotoListContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                 Lazy<PhotoListTabletPresenter> tabletPresenterLazy,
                                                 PhotoListPresenter photoListPresenter) {
        if (isTablet) {
            final PhotoListTabletPresenter photoListTabletPresenter = tabletPresenterLazy.get();
            photoListTabletPresenter.setPhotoListPresenter(photoListPresenter);
            return photoListTabletPresenter;
        } else {
            return photoListPresenter;
        }
    }

}
