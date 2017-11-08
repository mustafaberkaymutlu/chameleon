package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.di.scope.FragmentScoped;
import net.epictimes.chameleon.di.doc.IsTablet;
import net.epictimes.chameleon.features.list.PhotoListTabletPresenter;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoDetailFragmentModule {

    @FragmentScoped
    @Provides
    PhotoDetailPresenter providePresenterImpl(PhotoRepository photoRepository,
                                              PhotoDetailFragment photoDetailFragment) {
        return new PhotoDetailPresenter(photoDetailFragment, photoRepository);
    }

    @FragmentScoped
    @Provides
    PhotoDetailContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                   Lazy<PhotoListTabletPresenter> tabletPresenterLazy,
                                                   PhotoDetailPresenter detailPresenter) {
        if (isTablet) {
            final PhotoListTabletPresenter photoListTabletPresenter = tabletPresenterLazy.get();
            photoListTabletPresenter.setPhotoDetailPresenter(detailPresenter);
            return photoListTabletPresenter;
        } else {
            return detailPresenter;
        }
    }

}
