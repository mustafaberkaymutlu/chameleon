package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.PhotoRepository;

public class PhotoDetailPresenter implements PhotoDetailContract.Presenter {
    private final PhotoRepository photoRepository;
    private PhotoDetailContract.View view;
    private final Integer photoId;

    public PhotoDetailPresenter(PhotoRepository photoRepository,
                                PhotoDetailContract.View view) {
        this.photoRepository = photoRepository;
        this.photoId = 0; // TODO fix me
        this.view = view;
    }

    @Override
    public void loadTask() {

    }

    @Override
    public void dropView() {
        view = null;
    }
}
