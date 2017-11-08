package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.model.Photo;

public class PhotoDetailPresenter implements PhotoDetailContract.Presenter {
    private final PhotoRepository photoRepository;
    private PhotoDetailContract.View view;
    private int photoId = -1;

    PhotoDetailPresenter(PhotoDetailContract.View view, PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
        this.view = view;
    }

    @Override
    public void loadPhoto() {
        if (photoId == -1) {
            view.showMissingPhoto();
            return;
        }

        photoRepository.getPhoto(photoId, new PhotoDataSource.LoadPhotoCallback() {
            @Override
            public void onPhotoLoaded(Photo photo) {
                if (view != null && view.isActive()) {
                    view.showPhoto(photo);
                }
            }

            @Override
            public void onPhotoNotAvailable() {
                if (view != null && view.isActive()) {
                    view.showErrorDisplayingPhoto();
                }
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
