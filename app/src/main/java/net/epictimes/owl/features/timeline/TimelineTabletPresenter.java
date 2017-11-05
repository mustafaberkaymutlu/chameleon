package net.epictimes.owl.features.timeline;

import android.support.annotation.NonNull;

import net.epictimes.owl.data.model.Tweet;
import net.epictimes.owl.features.detail.TweetDetailContract;

public class TimelineTabletPresenter implements TimelineContract.Presenter, TweetDetailContract.Presenter {
    private TimelineContract.Presenter timelinePresenter;
    private TweetDetailContract.Presenter tweetDetailPresenter;

    public void setTimelinePresenter(@NonNull TimelineContract.Presenter timelinePresenter) {
        this.timelinePresenter = timelinePresenter;
    }

    public void setTweetDetailPresenter(@NonNull TweetDetailContract.Presenter tweetDetailPresenter) {
        this.tweetDetailPresenter = tweetDetailPresenter;
    }

    @Override
    public void loadTask() {

    }

    @Override
    public void loadTimeline(boolean forceUpdate) {

    }

    @Override
    public void openTweetDetails(@NonNull Tweet requestedTweet) {

    }

    @Override
    public void checkUserSessionValidity() {
        timelinePresenter.checkUserSessionValidity();
    }

    @Override
    public void dropView() {
        timelinePresenter.dropView();
        tweetDetailPresenter.dropView();
    }
}
