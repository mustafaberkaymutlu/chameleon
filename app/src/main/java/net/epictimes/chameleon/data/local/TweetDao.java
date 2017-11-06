package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.epictimes.chameleon.data.model.Tweet;

import java.util.List;

@Dao
public interface TweetDao {

    @Query("SELECT * FROM tweets")
    List<Tweet> getTweets();

    @Query("SELECT * FROM tweets WHERE tweetId = :tweetId")
    Tweet getTweetById(String tweetId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTweet(Tweet tweet);

    @Query("DELETE FROM tweets WHERE tweetId = :tweetId")
    int deleteTweetById(String tweetId);

    @Query("DELETE FROM tweets")
    void deleteAllTweets();

}
