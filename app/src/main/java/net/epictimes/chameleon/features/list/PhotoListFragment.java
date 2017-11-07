package net.epictimes.chameleon.features.list;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.detail.PhotoDetailActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoListFragment extends Fragment implements PhotoListContract.View {

    @Inject
    PhotoListContract.Presenter presenter;

    private PhotosRecyclerViewAdapter recyclerViewAdapter;

    public static PhotoListFragment newInstance() {
        return new PhotoListFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerViewPhotos = view.findViewById(R.id.recyclerViewPhotos);
        initRecyclerView(recyclerViewPhotos);

        presenter.loadPhotos(false);
    }

    private void initRecyclerView(RecyclerView recyclerViewPhotos) {
        recyclerViewPhotos.setHasFixedSize(true);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewPhotos.setLayoutManager(linearLayoutManager);

        final DividerItemDecoration dividerItemDecoration
                = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        recyclerViewPhotos.addItemDecoration(dividerItemDecoration);

        final PhotosRecyclerViewAdapter.ClickListener clickListener = (view, position) -> {
            final Photo selectedPhoto = recyclerViewAdapter.getPhotoList().get(position);
            presenter.onPhotoSelected(selectedPhoto);
        };

        recyclerViewAdapter = new PhotosRecyclerViewAdapter();
        recyclerViewAdapter.setClickListener(clickListener);
        recyclerViewPhotos.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void showPhotoDetailUi(int photoId) {
        final Intent photoDetailIntent = PhotoDetailActivity.newIntent(getContext(), photoId);
        startActivity(photoDetailIntent);
    }

    @Override
    public void showPhotos(List<Photo> photos) {
        recyclerViewAdapter.getPhotoList().clear();
        recyclerViewAdapter.addAll(photos);
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadingPhotosError() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
