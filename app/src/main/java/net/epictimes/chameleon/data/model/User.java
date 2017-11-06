package net.epictimes.chameleon.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "users")
public class User {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    private Integer userId;

    @SerializedName("username")
    private String userName;

    @SerializedName("firstname")
    private String firstName;

    @SerializedName("lastname")
    private String lastName;

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    @SerializedName("usertype")
    private Integer userType;

    @SerializedName("fullname")
    private String fullName;

    @SerializedName("userpic_url")
    private String userPicUrl;

    @SerializedName("userpic_https_url")
    private String userPicHttpsUrl;

    @SerializedName("cover_url")
    private String coverUrl;

    @SerializedName("upgrade_status")
    private Integer upgradeStatus;

    @SerializedName("store_on")
    private Boolean storeOn;

    @SerializedName("affection")
    private Integer affection;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    public String getUserPicHttpsUrl() {
        return userPicHttpsUrl;
    }

    public void setUserPicHttpsUrl(String userPicHttpsUrl) {
        this.userPicHttpsUrl = userPicHttpsUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(Integer upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public Boolean getStoreOn() {
        return storeOn;
    }

    public void setStoreOn(Boolean storeOn) {
        this.storeOn = storeOn;
    }

    public Integer getAffection() {
        return affection;
    }

    public void setAffection(Integer affection) {
        this.affection = affection;
    }
}
