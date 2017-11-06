package net.epictimes.chameleon.data.remote;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.model.GetPhotosResponse;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.util.CollectionUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRemoteDataSource implements PhotoDataSource {

    @NonNull
    private final Services services;

    public PhotoRemoteDataSource(@NonNull Services services) {
        this.services = services;
    }

    @Override
    public void getPhotos(@NonNull LoadPhotosCallback callback) {
        services.getPopularPhotos()
                .enqueue(new Callback<GetPhotosResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<GetPhotosResponse> call,
                                           @NonNull Response<GetPhotosResponse> response) {
                        final GetPhotosResponse body = response.body();
                        if (body != null) {
                            final List<Photo> photos = body.getPhotos();

                            if (!CollectionUtils.isEmpty(photos)) {
                                callback.onPhotosLoaded(photos);
                            }
                        }

                        callback.onPhotosNotAvailable();
                    }

                    @Override
                    public void onFailure(@NonNull Call<GetPhotosResponse> call, @NonNull Throwable t) {
                        callback.onPhotosNotAvailable();
                    }
                });
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
