package net.epictimes.chameleon.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tweets"
//        foreignKeys = {
//                @ForeignKey(entity = User.class,
//                        parentColumns = "userId",
//                        childColumns = "user",
//                        onDelete = ForeignKey.CASCADE)
//        }
)
public class Tweet {

    /**
     * The string representation of the unique identifier for this Tweet. Implementations should use
     * this rather than the large integer in id
     */
    @NonNull
    @PrimaryKey
    @SerializedName("id_str")
    private String tweetId;

    /**
     * The user who posted this Tweet. Perspectival attributes embedded within this object are
     * unreliable. See Why are embedded objects stale or inaccurate?.
     */
    @Embedded
    @SerializedName("user")
    private User user;

    /**
     * The actual UTF-8 text of the status update. See twitter-text for details on what is currently
     * considered valid characters.
     */
    @SerializedName(value = "text", alternate = {"full_text"})
    private String text;

    /**
     * UTC time when this Tweet was created.
     */
    @SerializedName("created_at")
    private String createdAt;

    /**
     * Nullable. Indicates approximately how many times this Tweet has been "favorited" by Twitter
     * users.
     */
    @SerializedName("favorite_count")
    private Integer favoriteCount;

    /**
     * Nullable. Perspectival. Indicates whether this Tweet has been favorited by the authenticating
     * user.
     */
    @SerializedName("favorited")
    private boolean favorited;

    /**
     * Number of times this Tweet has been retweeted. This field is no longer capped at 99 and will
     * not turn into a String for "100+"
     */
    @SerializedName("retweet_count")
    private int retweetCount;

    /**
     * Perspectival. Indicates whether this Tweet has been retweeted by the authenticating user.
     */
    @SerializedName("retweeted")
    private boolean retweeted;

    @NonNull
    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(@NonNull String tweetId) {
        this.tweetId = tweetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }
}
