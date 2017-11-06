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
    public void loadTask() {

    }

    @Override
    public void loadPhotos(boolean forceUpdate) {

    }

    @Override
    public void openPhotoDetails(@NonNull Photo requestedPhoto) {

    }

    @Override
    public void dropView() {
        photoListPresenter.dropView();
        photoDetailPresenter.dropView();
    }
}
