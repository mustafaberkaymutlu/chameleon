package net.epictimes.owl.data.local;

import android.support.annotation.NonNull;

import net.epictimes.owl.data.TweetsDataSource;
import net.epictimes.owl.data.model.Tweet;
import net.epictimes.owl.util.AppExecutors;

import java.util.List;

public class TweetsLocalDataSource implements TweetsDataSource {
    private final AppExecutors appExecutors;
    private final TweetDao tweetDao;

    public TweetsLocalDataSource(AppExecutors appExecutors, TweetDao tweetDao) {
        this.appExecutors = appExecutors;
        this.tweetDao = tweetDao;
    }

    @Override
    public void getTimeline(@NonNull LoadTimelineCallback callback) {
        appExecutors.getDiskIoExecutor().execute(() -> {
            final List<Tweet> tweets = tweetDao.getTweets();

            appExecutors.getMainThreadExecutor().execute(() -> {
                if (tweets.isEmpty()) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onTimelineLoaded(tweets);
                }
            });
        });
    }

    @Override
    public void getTweet(@NonNull String tweetId, @NonNull GetTweetCallback callback) {
        appExecutors.getDiskIoExecutor().execute(() -> {
            final Tweet tweet = tweetDao.getTweetById(tweetId);

            appExecutors.getMainThreadExecutor().execute(() -> {
                if (tweet != null) {
                    callback.onTweetLoaded(tweet);
                } else {
                    callback.onDataNotAvailable();
                }
            });
        });
    }

    @Override
    public void saveTweet(@NonNull Tweet tweet) {
        appExecutors.getDiskIoExecutor().execute(() -> tweetDao.insertTweet(tweet));
    }

    @Override
    public void deleteTweet(@NonNull String tweetIdStr) {
        appExecutors.getDiskIoExecutor().execute(() -> tweetDao.deleteTweetById(tweetIdStr));
    }

    @Override
    public void deleteAllTweets() {
        appExecutors.getDiskIoExecutor().execute(tweetDao::deleteAllTweets);
    }

    @Override
    public void refreshTimeline() {
        // no-op
    }
}
