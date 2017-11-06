package net.epictimes.chameleon.features.timeline;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.data.UsersRepository;
import net.epictimes.chameleon.di.FragmentScoped;
import net.epictimes.chameleon.di.IsTablet;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class TimelineFragmentModule {

    @FragmentScoped
    @Provides
    TimelinePresenter providePresenterImpl(TweetsRepository tweetsRepository,
                                           UsersRepository usersRepository,
                                           TimelineFragment timelineFragment) {
        return new TimelinePresenter(timelineFragment, tweetsRepository, usersRepository);
    }

    @FragmentScoped
    @Provides
    TimelineContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                Lazy<TimelineTabletPresenter> tabletPresenterLazy,
                                                TimelinePresenter timelinePresenter) {
        if (isTablet) {
            final TimelineTabletPresenter timelineTabletPresenter = tabletPresenterLazy.get();
            timelineTabletPresenter.setTimelinePresenter(timelinePresenter);
            return timelineTabletPresenter;
        } else {
            return timelinePresenter;
        }
    }

}
