package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Tweet;

import java.util.List;

public interface TweetsDataSource {

    interface LoadTimelineCallback {

        void onTimelineLoaded(List<Tweet> tweets);

        void onDataNotAvailable();
    }

    interface GetTweetCallback {

        void onTweetLoaded(Tweet tweet);

        void onDataNotAvailable();
    }


    void getTimeline(@NonNull LoadTimelineCallback callback);

    void getTweet(@NonNull String tweetId, @NonNull GetTweetCallback callback);

    void saveTweet(@NonNull Tweet tweet);

    void deleteTweet(@NonNull String tweetIdStr);

    void deleteAllTweets();

    void refreshTimeline();

}
