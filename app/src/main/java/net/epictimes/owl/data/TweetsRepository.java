package net.epictimes.owl.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.epictimes.owl.data.model.Tweet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TweetsRepository implements TweetsDataSource {

    @NonNull
    private final TweetsDataSource tweetsRemoteDataSource;

    @NonNull
    private final TweetsDataSource tweetsLocalDataSource;

    private final Map<String, Tweet> cachedTweets = new LinkedHashMap<>();

    private boolean isCacheDirty = false;

    public TweetsRepository(@NonNull TweetsDataSource tweetsRemoteDataSource,
                            @NonNull TweetsDataSource tweetsLocalDataSource) {
        this.tweetsRemoteDataSource = tweetsRemoteDataSource;
        this.tweetsLocalDataSource = tweetsLocalDataSource;
    }

    @Override
    public void getTimeline(@NonNull LoadTimelineCallback callback) {
        if (!cachedTweets.isEmpty() && !isCacheDirty) {
            callback.onTimelineLoaded(new ArrayList<>(cachedTweets.values()));
            return;
        }

        if (isCacheDirty) {
            getTasksFromRemoteDataSource(callback);
        } else {
            tweetsRemoteDataSource.getTimeline(new LoadTimelineCallback() {
                @Override
                public void onTimelineLoaded(List<Tweet> tweets) {
                    refreshCache(tweets);
                    refreshLocalDataSource(tweets);
                    callback.onTimelineLoaded(new ArrayList<>(cachedTweets.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    getTasksFromRemoteDataSource(callback);
                }
            });
        }
    }

    @Override
    public void getTweet(@NonNull String tweetId, @NonNull GetTweetCallback callback) {
        Tweet cachedTweet = getTweetFromCache(tweetId);

        if (cachedTweet != null) {
            callback.onTweetLoaded(cachedTweet);
            return;
        }

        tweetsLocalDataSource.getTweet(tweetId, new GetTweetCallback() {
            @Override
            public void onTweetLoaded(Tweet tweet) {
                cachedTweets.put(tweet.getTweetId(), tweet);
                callback.onTweetLoaded(tweet);
            }

            @Override
            public void onDataNotAvailable() {
                tweetsRemoteDataSource.getTweet(tweetId, new GetTweetCallback() {
                    @Override
                    public void onTweetLoaded(Tweet tweet) {
                        cachedTweets.put(tweet.getTweetId(), tweet);
                        callback.onTweetLoaded(tweet);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveTweet(@NonNull Tweet tweet) {
        tweetsLocalDataSource.saveTweet(tweet);
        cachedTweets.put(tweet.getTweetId(), tweet);
    }

    @Override
    public void deleteTweet(@NonNull String tweetIdStr) {
        tweetsLocalDataSource.deleteTweet(tweetIdStr);
        cachedTweets.remove(tweetIdStr);
    }

    @Override
    public void deleteAllTweets() {
        tweetsLocalDataSource.deleteAllTweets();
        cachedTweets.clear();
    }

    @Override
    public void refreshTimeline() {
        isCacheDirty = true;
    }

    private void getTasksFromRemoteDataSource(@NonNull final LoadTimelineCallback callback) {
        tweetsRemoteDataSource.getTimeline(new LoadTimelineCallback() {
            @Override
            public void onTimelineLoaded(List<Tweet> tweets) {
                refreshCache(tweets);
                refreshLocalDataSource(tweets);
                callback.onTimelineLoaded(new ArrayList<>(cachedTweets.values()));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }


    private void refreshCache(@NonNull Iterable<Tweet> tweets) {
        cachedTweets.clear();

        for (Tweet tweet : tweets) {
            cachedTweets.put(tweet.getTweetId(), tweet);
        }

        isCacheDirty = false;
    }

    private void refreshLocalDataSource(@NonNull Iterable<Tweet> tweets) {
        tweetsLocalDataSource.deleteAllTweets();

        for (Tweet tweet : tweets) {
            tweetsLocalDataSource.saveTweet(tweet);
        }
    }

    @Nullable
    private Tweet getTweetFromCache(@NonNull String tweetId) {
        if (cachedTweets.isEmpty()) {
            return null;
        } else {
            return cachedTweets.get(tweetId);
        }
    }
}
