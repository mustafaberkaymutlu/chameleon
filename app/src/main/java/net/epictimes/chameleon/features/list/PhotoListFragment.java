package net.epictimes.chameleon.features.list;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Tweet;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoListFragment extends Fragment implements PhotoListContract.View {

    @Inject
    PhotoListContract.Presenter presenter;

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
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void showTweetDetailUi(String tweetId) {

    }

    @Override
    public void showTweets(List<Tweet> tweets) {

    }

    @Override
    public void showNoTweets() {

    }

    @Override
    public void showLoadingTimelineError() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
