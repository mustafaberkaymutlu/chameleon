package net.epictimes.chameleon.features.list;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.detail.PhotoDetailContract;

public class PhotoListTabletPresenter implements PhotoListContract.Presenter,
        PhotoDetailContract.Presenter {
    private PhotoListContract.Presenter photoListPresenter;
    private PhotoDetailContract.Presenter photoDetailPresenter;

    public void setPhotoListPresenter(@NonNull PhotoListContract.Presenter photoListPresenter) {
        this.photoListPresenter = photoListPresenter;
    }

    public void setPhotoDetailPresenter(@NonNull PhotoDetailContract.Presenter photoDetailPresenter) {
        this.photoDetailPresenter = photoDetailPresenter;
    }

    @Override
    public void loadPhoto() {
        photoDetailPresenter.loadPhoto();
    }

    @Override
    public void setPhotoId(int photoId) {
        photoDetailPresenter.setPhotoId(photoId);
    }

    @Override
    public void loadPhotos() {
        photoListPresenter.loadPhotos();
    }

    @Override
    public void onPhotoSelected(Photo selectedPhoto) {
        photoDetailPresenter.setPhotoId(selectedPhoto.getPhotoId());
        photoDetailPresenter.loadPhoto();
    }

    @Override
    public void dropView() {
        photoListPresenter.dropView();
        photoDetailPresenter.dropView();
    }
}
