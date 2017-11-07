package net.epictimes.chameleon.features.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Photo;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoDetailFragment extends Fragment implements PhotoDetailContract.View {
    private static final String KEY_PHOTO_ID = "photo_i̇d";

    @Inject
    PhotoDetailContract.Presenter presenter;

    public static PhotoDetailFragment newInstance() {
        return new PhotoDetailFragment();
    }

    public static PhotoDetailFragment newInstance(int photoId) {
        final Bundle args = new Bundle();
        args.putInt(KEY_PHOTO_ID, photoId);
        final PhotoDetailFragment fragment = new PhotoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle args = getArguments();
        final int photoId = args.getInt(KEY_PHOTO_ID, -1);

        presenter.setPhotoId(photoId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.loadPhoto();
    }

    @Override
    public void showPhoto(Photo photo) {
        Toast.makeText(getContext(), "photo name: " + photo.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMissingPhoto() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
