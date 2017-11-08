package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.epictimes.chameleon.data.model.Photo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhotoRepository implements PhotoDataSource {

    @NonNull
    private final PhotoDataSource photoRemoteDataSource;

    @NonNull
    private final PhotoDataSource photoLocalDataSource;

    private final Map<Integer, Photo> cachedPhotos = new LinkedHashMap<>();

    private boolean isCacheDirty = false;

    public PhotoRepository(@NonNull PhotoDataSource photoRemoteDataSource,
                           @NonNull PhotoDataSource photoLocalDataSource) {
        this.photoRemoteDataSource = photoRemoteDataSource;
        this.photoLocalDataSource = photoLocalDataSource;
    }

    @Override
    public void getPhotos(@NonNull LoadPhotosCallback callback) {
        if (!cachedPhotos.isEmpty() && !isCacheDirty) {
            callback.onPhotosLoaded(new ArrayList<>(cachedPhotos.values()));
            return;
        }

        if (isCacheDirty) {
            getPhotosFromRemoteDataSource(callback);
        } else {
            photoRemoteDataSource.getPhotos(new LoadPhotosCallback() {
                @Override
                public void onPhotosLoaded(List<Photo> photos) {
                    refreshCache(photos);
                    refreshLocalDataSource(photos);
                    callback.onPhotosLoaded(new ArrayList<>(cachedPhotos.values()));
                }

                @Override
                public void onPhotosNotAvailable() {
                    getPhotosFromRemoteDataSource(callback);
                }
            });
        }
    }

    @Override
    public void getPhoto(int photoId, @NonNull GetPhotoCallback callback) {
        Photo cachedPhoto = getPhotoFromCache(photoId);

        if (cachedPhoto != null) {
            callback.onPhotoLoaded(cachedPhoto);
            return;
        }

        photoLocalDataSource.getPhoto(photoId, new GetPhotoCallback() {
            @Override
            public void onPhotoLoaded(Photo photo) {
                cachedPhotos.put(photo.getPhotoId(), photo);
                callback.onPhotoLoaded(photo);
            }

            @Override
            public void onPhotoNotAvailable() {
                photoRemoteDataSource.getPhoto(photoId, new GetPhotoCallback() {
                    @Override
                    public void onPhotoLoaded(Photo photo) {
                        cachedPhotos.put(photo.getPhotoId(), photo);
                        callback.onPhotoLoaded(photo);
                    }

                    @Override
                    public void onPhotoNotAvailable() {
                        callback.onPhotoNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void savePhoto(@NonNull Photo photo) {
        photoLocalDataSource.savePhoto(photo);
        cachedPhotos.put(photo.getPhotoId(), photo);
    }

    @Override
    public void deletePhoto(int photoId) {
        photoLocalDataSource.deletePhoto(photoId);
        cachedPhotos.remove(photoId);
    }

    @Override
    public void deleteAllPhotos() {
        photoLocalDataSource.deleteAllPhotos();
        cachedPhotos.clear();
    }

    @Override
    public void refreshPhotos() {
        isCacheDirty = true;
    }

    private void getPhotosFromRemoteDataSource(@NonNull final LoadPhotosCallback callback) {
        photoRemoteDataSource.getPhotos(new LoadPhotosCallback() {
            @Override
            public void onPhotosLoaded(List<Photo> photos) {
                refreshCache(photos);
                refreshLocalDataSource(photos);
                callback.onPhotosLoaded(new ArrayList<>(cachedPhotos.values()));
            }

            @Override
            public void onPhotosNotAvailable() {
                callback.onPhotosNotAvailable();
            }
        });
    }


    private void refreshCache(@NonNull Iterable<Photo> photos) {
        cachedPhotos.clear();

        for (Photo photo : photos) {
            cachedPhotos.put(photo.getPhotoId(), photo);
        }

        isCacheDirty = false;
    }

    private void refreshLocalDataSource(@NonNull Iterable<Photo> photos) {
        photoLocalDataSource.deleteAllPhotos();

        for (Photo photo : photos) {
            photoLocalDataSource.savePhoto(photo);
        }
    }

    @Nullable
    private Photo getPhotoFromCache(@NonNull Integer photoId) {
        if (cachedPhotos.isEmpty()) {
            return null;
        } else {
            return cachedPhotos.get(photoId);
        }
    }
}
