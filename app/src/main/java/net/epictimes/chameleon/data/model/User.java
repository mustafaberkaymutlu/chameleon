package net.epictimes.chameleon.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private Integer userId;

    @SerializedName("username")
    private String userName;

    @SerializedName("fullname")
    private String fullName;

    @SerializedName("userpic_url")
    private String userPicUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }
}
