package net.epictimes.owl.features.detail;

import net.epictimes.owl.data.TweetsRepository;
import net.epictimes.owl.di.FragmentScoped;
import net.epictimes.owl.di.IsTablet;
import net.epictimes.owl.features.timeline.TimelineTabletPresenter;

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
