package net.epictimes.chameleon.features.list;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.UserRepository;
import net.epictimes.chameleon.data.model.Photo;

public class PhotoListPresenter implements PhotoListContract.Presenter {

    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;
    private PhotoListContract.View view;

    public PhotoListPresenter(PhotoListContract.View view,
                              PhotoRepository photoRepository,
                              UserRepository userRepository) {
        this.photoRepository = photoRepository;
        this.view = view;
        this.userRepository = userRepository;
    }

    @Override
    public void loadPhotos(boolean forceUpdate) {

    }

    @Override
    public void openPhotoDetails(@NonNull Photo requestedPhoto) {

    }

    @Override
    public void dropView() {
        view = null;
    }
}
