package net.epictimes.owl.features.timeline;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.owl.R;
import net.epictimes.owl.data.model.Tweet;
import net.epictimes.owl.features.login.LoginActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class TimelineFragment extends Fragment implements TimelineContract.View {

    @Inject
    TimelineContract.Presenter presenter;

    public static TimelineFragment newInstance() {
        return new TimelineFragment();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.checkUserSessionValidity();
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
    public void goToLogin() {
        final Intent loginIntent = LoginActivity.newIntent(getContext());
        loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
