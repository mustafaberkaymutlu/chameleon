package net.epictimes.chameleon.data.remote;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.TweetsDataSource;
import net.epictimes.chameleon.data.model.Tweet;

public class TweetsRemoteDataSource implements TweetsDataSource {

    @NonNull
    private final Services services;

    public TweetsRemoteDataSource(@NonNull Services services) {
        this.services = services;
    }

    @Override
    public void getTimeline(@NonNull LoadTimelineCallback callback) {

    }

    @Override
    public void getTweet(@NonNull String tweetId, @NonNull GetTweetCallback callback) {

    }

    @Override
    public void saveTweet(@NonNull Tweet tweet) {
        // no-op
    }

    @Override
    public void deleteTweet(@NonNull String tweetIdStr) {
        // no-op
    }

    @Override
    public void deleteAllTweets() {
        // no-op
    }

    @Override
    public void refreshTimeline() {

    }
}