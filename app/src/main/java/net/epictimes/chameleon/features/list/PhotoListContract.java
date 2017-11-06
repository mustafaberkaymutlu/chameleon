package net.epictimes.chameleon.features.list;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

import java.util.List;

public interface PhotoListContract {

    interface View extends BaseView<Presenter> {

        void showPhotoDetailUi(Integer photoId);

        void showPhotos(List<Photo> photos);

        void showLoadingPhotosError();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        /**
         * @param forceUpdate reload data triggering a refresh from source of truth.
         */
        void loadPhotos(boolean forceUpdate);

        void openPhotoDetails(@NonNull Photo requestedPhoto);

    }

}
