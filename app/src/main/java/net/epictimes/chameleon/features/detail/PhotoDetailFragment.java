package net.epictimes.chameleon.features.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.util.GlideApp;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoDetailFragment extends Fragment implements PhotoDetailContract.View {
    private static final String KEY_PHOTO_ID = "photo_i̇d";
    private static final String KEY_INFO_SHOWING = "info_showing";

    @Inject
    PhotoDetailContract.Presenter presenter;

    private PhotoView photoView;
    private ConstraintLayout containerInfo;
    private ImageView imageViewUser;
    private TextView textViewUserName;
    private TextView textViewCreated;
    private TextView textViewLikeCount;
    private FragmentListener fragmentListener;

    private int photoId = -1;
    private boolean isInfoShowing = true;

    public interface FragmentListener {
        void setToolbarTitle(String title);
    }

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

        try {
            fragmentListener = (FragmentListener) context;
        } catch (ClassCastException ignored) {
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            photoId = savedInstanceState.getInt(KEY_PHOTO_ID);
            isInfoShowing = savedInstanceState.getBoolean(KEY_INFO_SHOWING);
        } else {
            final Bundle args = getArguments();
            if (args != null) {
                photoId = args.getInt(KEY_PHOTO_ID, -1);
            }
        }

        presenter.setPhotoId(photoId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        photoView = view.findViewById(R.id.photoViewPhoto);
        containerInfo = view.findViewById(R.id.containerInfo);
        imageViewUser = view.findViewById(R.id.imageViewPhoto);
        textViewUserName = view.findViewById(R.id.textViewUserName);
        textViewCreated = view.findViewById(R.id.textViewCreated);
        textViewLikeCount = view.findViewById(R.id.textViewLikeCount);

        photoView.setOnViewTapListener((view1, x, y) -> {
            isInfoShowing = !isInfoShowing;
            updateInfoContainerVisibility();
        });

        updateInfoContainerVisibility();
    }

    private void updateInfoContainerVisibility() {
        containerInfo.setVisibility(isInfoShowing ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.loadPhoto();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_PHOTO_ID, photoId);
        outState.putBoolean(KEY_INFO_SHOWING, isInfoShowing);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showPhoto(Photo photo) {
        this.photoId = photo.getPhotoId();

        GlideApp.with(this)
                .load(photo.getImageUrl())
                .into(photoView);

        GlideApp.with(this)
                .load(photo.getUser().getUserPicUrl())
                .into(imageViewUser);

        textViewUserName.setText(photo.getUser().getFullName());
        textViewCreated.setText(photo.getCreatedAt().toString());

        final String likeCount = getResources().getQuantityString(R.plurals.likeCount,
                photo.getVotesCount(), photo.getVotesCount());
        textViewLikeCount.setText(likeCount);

        fragmentListener.setToolbarTitle(photo.getName());
    }

    @Override
    public void showMissingPhoto() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
