package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

import java.util.List;

public interface PhotoListContract {

    interface View extends BaseView<Presenter> {

        void showPhotoDetailUi(int photoId);

        void showPhotos(List<Photo> photos);

        void showLoadingPhotosError();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadPhotos();

        void onPhotoSelected(Photo selectedPhoto);

    }

}
