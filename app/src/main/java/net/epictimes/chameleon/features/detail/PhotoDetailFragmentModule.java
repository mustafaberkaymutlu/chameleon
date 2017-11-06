package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.di.FragmentScoped;
import net.epictimes.chameleon.di.IsTablet;
import net.epictimes.chameleon.features.list.PhotoListTabletPresenter;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoDetailFragmentModule {

    @FragmentScoped
    @Provides
    PhotoDetailPresenter providePresenterImpl(TweetsRepository tweetsRepository,
                                              PhotoDetailFragment photoDetailFragment) {
        return new PhotoDetailPresenter(tweetsRepository, photoDetailFragment);
    }

    @FragmentScoped
    @Provides
    PhotoDetailContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                   Lazy<PhotoListTabletPresenter> tabletPresenterLazy,
                                                   PhotoDetailPresenter detailPresenter) {
        if (isTablet) {
            final PhotoListTabletPresenter photoListTabletPresenter = tabletPresenterLazy.get();
            photoListTabletPresenter.setTweetDetailPresenter(detailPresenter);
            return photoListTabletPresenter;
        } else {
            return detailPresenter;
        }
    }

}
