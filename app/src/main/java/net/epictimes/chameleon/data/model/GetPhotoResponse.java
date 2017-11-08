package net.epictimes.chameleon.data.model;

import com.google.gson.annotations.SerializedName;

public class GetPhotoResponse {

    @SerializedName("photo")
    private Photo photo;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
