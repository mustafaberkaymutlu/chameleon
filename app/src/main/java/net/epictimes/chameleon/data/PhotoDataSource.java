package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Photo;

import java.util.List;

public interface PhotoDataSource {

    interface LoadPhotosCallback {

        void onPhotosLoaded(List<Photo> photos);

        void onPhotosNotAvailable();
    }

    interface GetPhotoCallback {

        void onPhotoLoaded(Photo photo);

        void onPhotoNotAvailable();
    }


    void getPhotos(@NonNull LoadPhotosCallback callback);

    void getPhoto(int photoId, @NonNull GetPhotoCallback callback);

    void savePhoto(@NonNull Photo photo);

    void deletePhoto(int photoId);

    void deleteAllPhotos();

    void refreshPhotos();

}
