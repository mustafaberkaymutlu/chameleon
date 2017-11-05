package net.epictimes.owl.features.timeline;

import net.epictimes.owl.data.TweetsRepository;
import net.epictimes.owl.data.UsersRepository;
import net.epictimes.owl.di.FragmentScoped;
import net.epictimes.owl.di.IsTablet;

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
