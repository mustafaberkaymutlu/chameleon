package net.epictimes.chameleon.data.local;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.TweetsDataSource;
import net.epictimes.chameleon.data.model.Tweet;
import net.epictimes.chameleon.util.AppExecutors;

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
        appExecutors.diskIo().execute(() -> {
            final List<Tweet> tweets = tweetDao.getTweets();

            appExecutors.mainThread().execute(() -> {
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
        appExecutors.diskIo().execute(() -> {
            final Tweet tweet = tweetDao.getTweetById(tweetId);

            appExecutors.mainThread().execute(() -> {
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
        appExecutors.diskIo().execute(() -> tweetDao.insertTweet(tweet));
    }

    @Override
    public void deleteTweet(@NonNull String tweetIdStr) {
        appExecutors.diskIo().execute(() -> tweetDao.deleteTweetById(tweetIdStr));
    }

    @Override
    public void deleteAllTweets() {
        appExecutors.diskIo().execute(tweetDao::deleteAllTweets);
    }

    @Override
    public void refreshTimeline() {
        // no-op
    }
}
