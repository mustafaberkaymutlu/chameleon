package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.model.Photo;

public class PhotoDetailPresenter implements PhotoDetailContract.Presenter {
    private final PhotoRepository photoRepository;
    private PhotoDetailContract.View view;
    private int photoId = -1;

    PhotoDetailPresenter(PhotoRepository photoRepository, PhotoDetailContract.View view) {
        this.photoRepository = photoRepository;
        this.view = view;
    }

    @Override
    public void loadPhoto() {
        if (photoId == -1) {
            view.showMissingPhoto();
            return;
        }

        photoRepository.getPhoto(photoId, new PhotoDataSource.GetPhotoCallback() {
            @Override
            public void onPhotoLoaded(Photo photo) {
                if (!view.isActive()) {
                    return;
                }

                view.showPhoto(photo);
            }

            @Override
            public void onPhotoNotAvailable() {
                if (!view.isActive()) {
                    return;
                }

                view.showMissingPhoto();
            }
        });
    }

    @Override
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
