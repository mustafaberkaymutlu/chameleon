package net.epictimes.owl.features.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.owl.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class TweetDetailFragment extends Fragment implements TweetDetailContract.View {

    @Inject
    TweetDetailContract.Presenter presenter;

    public static TweetDetailFragment newInstance() {
        return new TweetDetailFragment();
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
