package net.epictimes.owl.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tweet {

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

    @SerializedName("id")
    private long id;

    @SerializedName("id_str")
    private String idStr;

    /**
     * This field only surfaces when the Tweet is a quote Tweet. This field contains the
     * integer value Tweet ID of the quoted Tweet.
     */
    @SerializedName("quoted_status_id")
    private long quotedStatusId;

    /**
     * This field only surfaces when the Tweet is a quote Tweet. This is the string representation
     * Tweet ID of the quoted Tweet.
     */
    @SerializedName("quoted_status_id_str")
    private String quotedStatusIdStr;

    /**
     * This field only surfaces when the Tweet is a quote Tweet. This attribute contains the
     * Tweet object of the original Tweet that was quoted.
     */
    @SerializedName("quoted_status")
    private Tweet quotedStatus;

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

    /**
     * Users can amplify the broadcast of tweets authored by other users by retweeting. Retweets can
     * be distinguished from typical Tweets by the existence of a retweeted_status attribute. This
     * attribute contains a representation of the original Tweet that was retweeted. Note that
     * retweets of retweets do not show representations of the intermediary retweet, but only the
     * original tweet. (Users can also unretweet a retweet they created by deleting their retweet.)
     */
    @SerializedName("retweeted_status")
    private Tweet retweetedStatus;

    /**
     * The actual UTF-8 text of the status update. See twitter-text for details on what is currently
     * considered valid characters.
     */
    @SerializedName(value = "text", alternate = {"full_text"})
    private String text;


    /**
     * An array of two unicode code point indices, identifying the inclusive start and exclusive end
     * of the displayable content of the Tweet.
     */
    @SerializedName("display_text_range")
    private List<Integer> displayTextRange;

    /**
     * Indicates whether the value of the text parameter was truncated, for example, as a result of
     * a retweet exceeding the 140 character Tweet length. Truncated text will end in ellipsis, like
     * this ... Since Twitter now rejects long Tweets vs truncating them, the large majority of
     * Tweets will have this set to false.
     * Note that while native retweets may have their toplevel text property shortened, the original
     * text will be available under the retweeted_status object and the truncated parameter will be
     * set to the value of the original status (in most cases, false).
     */
    @SerializedName("truncated")
    private boolean truncated;

    /**
     * The user who posted this Tweet. Perspectival attributes embedded within this object are
     * unreliable. See Why are embedded objects stale or inaccurate?.
     */
    @SerializedName("user")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Tweet)) {
            return false;
        }

        final Tweet other = (Tweet) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public long getQuotedStatusId() {
        return quotedStatusId;
    }

    public String getQuotedStatusIdStr() {
        return quotedStatusIdStr;
    }

    public Tweet getQuotedStatus() {
        return quotedStatus;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public Tweet getRetweetedStatus() {
        return retweetedStatus;
    }

    public String getText() {
        return text;
    }

    public List<Integer> getDisplayTextRange() {
        return displayTextRange;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public User getUser() {
        return user;
    }
}
