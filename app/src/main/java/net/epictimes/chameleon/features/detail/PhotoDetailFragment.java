package net.epictimes.chameleon.features.detail;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.util.GlideApp;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoDetailFragment extends Fragment implements PhotoDetailContract.View {
    private static final String KEY_PHOTO_ID = "photo_i̇d";
    private static final String KEY_INFO_SHOWING = "info_showing";
    private static final int CONTAINER_INFO_FADE_ANIM_DURATION = 200;

    @Inject
    PhotoDetailContract.Presenter presenter;

    private PhotoView photoView;
    private ConstraintLayout containerInfo;
    private ImageView imageViewUser;
    private TextView textViewUserName;
    private TextView textViewCreated;
    private TextView textViewLikeCount;
    private TextView textViewEmpty;

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
        textViewEmpty = view.findViewById(R.id.textViewEmpty);

        photoView.setOnViewTapListener((view1, x, y) -> {
            isInfoShowing = !isInfoShowing;
            updateInfoContainerVisibility();
        });

        updateInfoContainerVisibility();
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.loadPhoto();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        presenter.dropView();
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
                .fitCenter()
                .into(photoView);

        GlideApp.with(this)
                .load(photo.getUser().getUserPicUrl())
                .into(imageViewUser);

        textViewUserName.setText(photo.getUser().getFullName());
        textViewCreated.setText(photo.getCreatedAt().toString());

        final String likeCount = getResources().getQuantityString(R.plurals.likeCount,
                photo.getVotesCount(), photo.getVotesCount());
        textViewLikeCount.setText(likeCount);

        photoView.setVisibility(View.VISIBLE);
        textViewEmpty.setVisibility(View.GONE);

        fragmentListener.setToolbarTitle(photo.getName());
    }

    @Override
    public void showMissingPhoto() {
        containerInfo.setVisibility(View.GONE);
        photoView.setVisibility(View.GONE);
        textViewEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorDisplayingPhoto() {
        Toast.makeText(getContext(), R.string.error_loading_photo, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    private void updateInfoContainerVisibility() {
        if (isInfoShowing) {
            containerInfo.animate()
                    .alpha(1f)
                    .setDuration(CONTAINER_INFO_FADE_ANIM_DURATION)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);

                            containerInfo.setVisibility(View.VISIBLE);
                        }
                    });
        } else {
            containerInfo.animate()
                    .alpha(0f)
                    .setDuration(CONTAINER_INFO_FADE_ANIM_DURATION)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                            containerInfo.setVisibility(View.GONE);
                        }
                    });
        }
    }
}
