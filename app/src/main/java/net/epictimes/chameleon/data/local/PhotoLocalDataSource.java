package net.epictimes.chameleon.data.local;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.util.AppExecutors;

import java.util.List;

public class PhotoLocalDataSource implements PhotoDataSource {
    private final AppExecutors appExecutors;
    private final PhotoDao photoDao;

    PhotoLocalDataSource(AppExecutors appExecutors, PhotoDao photoDao) {
        this.appExecutors = appExecutors;
        this.photoDao = photoDao;
    }

    @Override
    public void getPhotos(@NonNull LoadPhotosCallback callback) {
        appExecutors.diskIo().execute(() -> {
            final List<Photo> photos = photoDao.getPhotos();

            appExecutors.mainThread().execute(() -> {
                if (photos.isEmpty()) {
                    callback.onPhotosNotAvailable();
                } else {
                    callback.onPhotosLoaded(photos);
                }
            });
        });
    }

    @Override
    public void getPhoto(int photoId, @NonNull LoadPhotoCallback callback) {
        appExecutors.diskIo().execute(() -> {
            final Photo photo = photoDao.getPhotoById(photoId);

            appExecutors.mainThread().execute(() -> {
                if (photo != null) {
                    callback.onPhotoLoaded(photo);
                } else {
                    callback.onPhotoNotAvailable();
                }
            });
        });
    }

    @Override
    public void savePhoto(@NonNull Photo photo) {
        appExecutors.diskIo().execute(() -> photoDao.insertPhoto(photo));
    }

    @Override
    public void deletePhoto(int photoId) {
        appExecutors.diskIo().execute(() -> photoDao.deletePhotoById(photoId));
    }

    @Override
    public void deleteAllPhotos() {
        appExecutors.diskIo().execute(photoDao::deleteAllPhotos);
    }

    @Override
    public void refreshPhotos() {
        // no-op
    }
}
