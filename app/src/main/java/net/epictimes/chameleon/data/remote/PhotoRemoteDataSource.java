package net.epictimes.chameleon.data.remote;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.model.Photo;

public class PhotoRemoteDataSource implements PhotoDataSource {

    @NonNull
    private final Services services;

    public PhotoRemoteDataSource(@NonNull Services services) {
        this.services = services;
    }

    @Override
    public void getPhotos(@NonNull LoadPhotosCallback callback) {

    }

    @Override
    public void getPhoto(@NonNull Integer photoId, @NonNull GetPhotoCallback callback) {

    }

    @Override
    public void savePhoto(@NonNull Photo photo) {
        // no-op
    }

    @Override
    public void deletePhoto(@NonNull String photoId) {
        // no-op
    }

    @Override
    public void deleteAllPhotos() {
        // no-op
    }

    @Override
    public void refreshPhotos() {

    }
}
