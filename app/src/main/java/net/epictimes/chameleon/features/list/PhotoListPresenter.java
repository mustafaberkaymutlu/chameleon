package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.model.Photo;

import java.util.List;

public class PhotoListPresenter implements PhotoListContract.Presenter {

    private final PhotoRepository photoRepository;
    private PhotoListContract.View view;

    PhotoListPresenter(PhotoListContract.View view, PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
        this.view = view;
    }

    @Override
    public void loadPhotos(boolean forceUpdate) {
        photoRepository.getPhotos(new PhotoDataSource.LoadPhotosCallback() {
            @Override
            public void onPhotosLoaded(List<Photo> photos) {
                if (view != null) {
                    view.showPhotos(photos);
                }
            }

            @Override
            public void onPhotosNotAvailable() {
                if (view != null) {
                    view.showLoadingPhotosError();
                }
            }
        });
    }

    @Override
    public void onPhotoSelected(Photo selectedPhoto) {
        view.showPhotoDetailUi(selectedPhoto.getPhotoId());
    }

    @Override
    public void dropView() {
        view = null;
    }
}
