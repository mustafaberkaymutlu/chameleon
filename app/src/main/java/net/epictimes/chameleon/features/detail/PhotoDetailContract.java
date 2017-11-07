package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

public interface PhotoDetailContract {

    interface View extends BaseView<Presenter> {

        void showPhoto(Photo photo);

        void showMissingPhoto();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadPhoto();

        void setPhotoId(int photoId);

    }

}
