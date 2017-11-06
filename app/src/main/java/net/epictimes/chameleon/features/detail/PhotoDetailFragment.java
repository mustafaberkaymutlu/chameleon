package net.epictimes.chameleon.features.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.chameleon.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoDetailFragment extends Fragment implements PhotoDetailContract.View {

    @Inject
    PhotoDetailContract.Presenter presenter;

    public static PhotoDetailFragment newInstance() {
        return new PhotoDetailFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tweet_detail, container, false);
    }

    @Override
    public void showMissingTask() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
