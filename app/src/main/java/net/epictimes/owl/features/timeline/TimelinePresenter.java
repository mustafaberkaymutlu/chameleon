package net.epictimes.owl.features.timeline;

import android.support.annotation.NonNull;

import net.epictimes.owl.data.TweetsRepository;
import net.epictimes.owl.data.model.Tweet;

public class TimelinePresenter implements TimelineContract.Presenter {

    private final TweetsRepository tweetsRepository;
    private TimelineContract.View view;

    public TimelinePresenter(TweetsRepository tweetsRepository, TimelineContract.View view) {
        this.tweetsRepository = tweetsRepository;
        this.view = view;
    }

    @Override
    public void loadTimeline(boolean forceUpdate) {

    }

    @Override
    public void openTweetDetails(@NonNull Tweet requestedTweet) {

    }

    @Override
    public void dropView() {
        view = null;
    }
}
