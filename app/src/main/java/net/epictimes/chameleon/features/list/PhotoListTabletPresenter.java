package net.epictimes.chameleon.features.list;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Tweet;
import net.epictimes.chameleon.features.detail.PhotoDetailContract;

public class PhotoListTabletPresenter implements PhotoListContract.Presenter,
        PhotoDetailContract.Presenter {
    private PhotoListContract.Presenter timelinePresenter;
    private PhotoDetailContract.Presenter tweetDetailPresenter;

    public void setTimelinePresenter(@NonNull PhotoListContract.Presenter timelinePresenter) {
        this.timelinePresenter = timelinePresenter;
    }

    public void setTweetDetailPresenter(@NonNull PhotoDetailContract.Presenter tweetDetailPresenter) {
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
    public void dropView() {
        timelinePresenter.dropView();
        tweetDetailPresenter.dropView();
    }
}
