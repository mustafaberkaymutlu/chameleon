package net.epictimes.chameleon.data.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "photos")
public class Photo {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    private Integer photoId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("camera")
    private String camera;

    @SerializedName("lens")
    private String lens;

    @SerializedName("focal_length")
    private String focalLength;

    @SerializedName("iso")
    private String iso;

    @SerializedName("shutter_speed")
    private String shutterSpeed;

    @SerializedName("aperture")
    private String aperture;

    @SerializedName("times_viewed")
    private Integer timesViewed;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("status")
    private Integer status;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("category")
    private Integer category;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    @SerializedName("taken_at")
    private String takenAt;

    @SerializedName("hi_res_uploaded")
    private Integer hiResUploaded;

    @SerializedName("for_sale")
    private Boolean forSale;

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("votes_count")
    private Integer votesCount;

    @SerializedName("favorites_count")
    private Integer favoritesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("nsfw")
    private Boolean nsfw;

    @SerializedName("sales_count")
    private Integer salesCount;

    @SerializedName("highest_rating")
    private Double highestRating;

    @SerializedName("license_type")
    private Integer licenseType;

    @SerializedName("converted")
    private Integer converted;

    @SerializedName("collections_count")
    private Integer collectionsCount;

    @SerializedName("crop_version")
    private Integer cropVersion;

    @SerializedName("privacy")
    private Boolean privacy;

    @SerializedName("profile")
    private Boolean profile;

    @SerializedName("for_critique")
    private Boolean forCritique;

    @SerializedName("critiques_callout_dismissed")
    private Boolean critiquesCalloutDismissed;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("url")
    private String url;

    @SerializedName("positive_votes_count")
    private Integer positiveVotesCount;

    @SerializedName("converted_bits")
    private Integer convertedBits;

    @SerializedName("watermark")
    private Boolean watermark;

    @SerializedName("image_format")
    private String imageFormat;

    @SerializedName("user")
    private User user;

    @SerializedName("licensing_requested")
    private Boolean licensingRequested;

    @SerializedName("licensing_suggested")
    private Boolean licensingSuggested;

    @SerializedName("is_free_photo")
    private Boolean isFreePhoto;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public Integer getTimesViewed() {
        return timesViewed;
    }

    public void setTimesViewed(Integer timesViewed) {
        this.timesViewed = timesViewed;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(String takenAt) {
        this.takenAt = takenAt;
    }

    public Integer getHiResUploaded() {
        return hiResUploaded;
    }

    public void setHiResUploaded(Integer hiResUploaded) {
        this.hiResUploaded = hiResUploaded;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }

    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public Double getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(Double highestRating) {
        this.highestRating = highestRating;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public Integer getConverted() {
        return converted;
    }

    public void setConverted(Integer converted) {
        this.converted = converted;
    }

    public Integer getCollectionsCount() {
        return collectionsCount;
    }

    public void setCollectionsCount(Integer collectionsCount) {
        this.collectionsCount = collectionsCount;
    }

    public Integer getCropVersion() {
        return cropVersion;
    }

    public void setCropVersion(Integer cropVersion) {
        this.cropVersion = cropVersion;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public Boolean getProfile() {
        return profile;
    }

    public void setProfile(Boolean profile) {
        this.profile = profile;
    }

    public Boolean getForCritique() {
        return forCritique;
    }

    public void setForCritique(Boolean forCritique) {
        this.forCritique = forCritique;
    }

    public Boolean getCritiquesCalloutDismissed() {
        return critiquesCalloutDismissed;
    }

    public void setCritiquesCalloutDismissed(Boolean critiquesCalloutDismissed) {
        this.critiquesCalloutDismissed = critiquesCalloutDismissed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPositiveVotesCount() {
        return positiveVotesCount;
    }

    public void setPositiveVotesCount(Integer positiveVotesCount) {
        this.positiveVotesCount = positiveVotesCount;
    }

    public Integer getConvertedBits() {
        return convertedBits;
    }

    public void setConvertedBits(Integer convertedBits) {
        this.convertedBits = convertedBits;
    }

    public Boolean getWatermark() {
        return watermark;
    }

    public void setWatermark(Boolean watermark) {
        this.watermark = watermark;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getLicensingRequested() {
        return licensingRequested;
    }

    public void setLicensingRequested(Boolean licensingRequested) {
        this.licensingRequested = licensingRequested;
    }

    public Boolean getLicensingSuggested() {
        return licensingSuggested;
    }

    public void setLicensingSuggested(Boolean licensingSuggested) {
        this.licensingSuggested = licensingSuggested;
    }

    public Boolean getIsFreePhoto() {
        return isFreePhoto;
    }

    public void setIsFreePhoto(Boolean isFreePhoto) {
        this.isFreePhoto = isFreePhoto;
    }

}
