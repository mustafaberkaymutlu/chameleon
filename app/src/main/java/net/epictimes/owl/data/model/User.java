package net.epictimes.owl.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    /**
     * When true, indicates that the user has not uploaded their own avatar and a default egg avatar
     * is used instead.
     */
    @SerializedName("default_profile_image")
    private boolean defaultProfileImage;

    /**
     * Nullable. The user-defined UTF-8 string describing their account.
     */
    @SerializedName("description")
    private String description;

    /**
     * The number of tweets this user has favorited in the account's lifetime. British spelling used
     * in the field name for historical reasons.
     */
    @SerializedName("favourites_count")
    private int favouritesCount;

    /**
     * Nullable. Perspectival. When true, indicates that the authenticating user has issued a follow
     * request to this protected user account.
     */
    @SerializedName("follow_request_sent")
    private boolean followRequestSent;

    /**
     * The number of followers this account currently has. Under certain conditions of duress, this
     * field will temporarily indicate "0."
     */
    @SerializedName("followers_count")
    private int followersCount;

    /**
     * The number of users this account is following (AKA their "followings"). Under certain
     * conditions of duress, this field will temporarily indicate "0."
     */
    @SerializedName("friends_count")
    private int friendsCount;

    /**
     * The integer representation of the unique identifier for this User. This number is greater
     * than 53 bits and some programming languages may have difficulty/silent defects in
     * interpreting it. Using a signed 64 bit integer for storing this identifier is safe. Use
     * id_str for fetching the identifier to stay on the safe side. See Twitter IDs, JSON and
     * Snowflake.
     */
    @SerializedName("id")
    private long id;

    /**
     * The string representation of the unique identifier for this User. Implementations should use
     * this rather than the large, possibly un-consumable integer in id
     */
    @SerializedName("id_str")
    private String idStr;

    /**
     * The name of the user, as they've defined it. Not necessarily a person's name. Typically
     * capped at 20 characters, but subject to change.
     */
    @SerializedName("name")
    private String name;

    /**
     * The hexadecimal color chosen by the user for their background.
     */
    @SerializedName("profile_background_color")
    private String profileBackgroundColor;

    /**
     * The HTTPS-based URL pointing to the standard web representation of the user's uploaded
     * profile banner. By adding a path element of the URL, you can obtain different image
     * sizes optimized for specific displays. In the future, an API method will be provided to serve
     * these URLs so that you need not modify the original URL. For size variations, please see
     * User Profile Images and Banners.
     */
    @SerializedName("profile_banner_url")
    private String profileBannerUrl;

    /**
     * A HTTPS-based URL pointing to the user's avatar image.
     */
    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;

    /**
     * The hexadecimal color the user has chosen to display links with in their Twitter UI.
     */
    @SerializedName("profile_link_color")
    private String profileLinkColor;

    /**
     * When true, indicates that this user has chosen to protect their Tweets. See About Public and
     * Protected Tweets.
     */
    @SerializedName("protected")
    private boolean protectedUser;

    /**
     * The screen name, handle, or alias that this user identifies themselves with. screen_names are
     * unique but subject to change. Use id_str as a user identifier whenever possible. Typically a
     * maximum of 15 characters long, but some historical accounts may exist with longer names.
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * Indicates that the user would like to see media inline. Somewhat disused.
     */
    @SerializedName("show_all_inline_media")
    private boolean showAllInlineMedia;

    /**
     * The number of tweets (including retweets) issued by the user.
     */
    @SerializedName("statuses_count")
    private int statusesCount;

    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    public String getDescription() {
        return description;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public boolean isFollowRequestSent() {
        return followRequestSent;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getName() {
        return name;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public boolean isProtectedUser() {
        return protectedUser;
    }

    public String getScreenName() {
        return screenName;
    }

    public boolean isShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    public int getStatusesCount() {
        return statusesCount;
    }
}
