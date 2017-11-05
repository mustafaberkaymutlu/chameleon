package net.epictimes.owl.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "users")
public class User {

    /**
     * The string representation of the unique identifier for this User. Implementations should use
     * this rather than the large, possibly un-consumable integer in id
     */
    @NonNull
    @PrimaryKey
    @SerializedName("id_str")
    private String userId;

    /**
     * The name of the user, as they've defined it. Not necessarily a person's name. Typically
     * capped at 20 characters, but subject to change.
     */
    @SerializedName("name")
    private String name;

    /**
     * The screen name, handle, or alias that this user identifies themselves with. screen_names are
     * unique but subject to change. Use id_str as a user identifier whenever possible. Typically a
     * maximum of 15 characters long, but some historical accounts may exist with longer names.
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * A HTTPS-based URL pointing to the user's avatar image.
     */
    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }
}
