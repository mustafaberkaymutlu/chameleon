package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.data.UsersRepository;
import net.epictimes.chameleon.di.FragmentScoped;
import net.epictimes.chameleon.di.IsTablet;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoListFragmentModule {

    @FragmentScoped
    @Provides
    PhotoListPresenter providePresenterImpl(TweetsRepository tweetsRepository,
                                            UsersRepository usersRepository,
                                            PhotoListFragment photoListFragment) {
        return new PhotoListPresenter(photoListFragment, tweetsRepository, usersRepository);
    }

    @FragmentScoped
    @Provides
    PhotoListContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                 Lazy<PhotoListTabletPresenter> tabletPresenterLazy,
                                                 PhotoListPresenter photoListPresenter) {
        if (isTablet) {
            final PhotoListTabletPresenter photoListTabletPresenter = tabletPresenterLazy.get();
            photoListTabletPresenter.setTimelinePresenter(photoListPresenter);
            return photoListTabletPresenter;
        } else {
            return photoListPresenter;
        }
    }

}
