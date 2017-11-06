package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.di.FragmentScoped;
import net.epictimes.chameleon.di.IsTablet;
import net.epictimes.chameleon.features.timeline.TimelineTabletPresenter;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class TweetDetailFragmentModule {

    @FragmentScoped
    @Provides
    TweetDetailPresenter providePresenterImpl(TweetsRepository tweetsRepository,
                                              TweetDetailFragment tweetDetailFragment) {
        return new TweetDetailPresenter(tweetsRepository, tweetDetailFragment);
    }

    @FragmentScoped
    @Provides
    TweetDetailContract.Presenter providePresenter(@IsTablet boolean isTablet,
                                                   Lazy<TimelineTabletPresenter> tabletPresenterLazy,
                                                   TweetDetailPresenter detailPresenter) {
        if (isTablet) {
            final TimelineTabletPresenter timelineTabletPresenter = tabletPresenterLazy.get();
            timelineTabletPresenter.setTweetDetailPresenter(detailPresenter);
            return timelineTabletPresenter;
        } else {
            return detailPresenter;
        }
    }

}
