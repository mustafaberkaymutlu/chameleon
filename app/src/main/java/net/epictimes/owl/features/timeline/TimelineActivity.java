package net.epictimes.owl.features.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.epictimes.owl.R;
import net.epictimes.owl.di.IsTablet;
import net.epictimes.owl.features.detail.TweetDetailFragment;
import net.epictimes.owl.features.login.LoginActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class TimelineActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private static final String CURRENT_TASK_ID_KEY = "key_current_task_i̇d";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @IsTablet
    @Inject
    boolean isTablet;

    private String tweetId;

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, TimelineActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        setupActionBar();

        checkUserSession();

        if (savedInstanceState != null) {
            tweetId = savedInstanceState.getString(CURRENT_TASK_ID_KEY);
        }

        if (isTablet) {
            attachTabletFragments();
        } else {
            attachPhoneFragments();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(CURRENT_TASK_ID_KEY, tweetId);
        super.onSaveInstanceState(outState);
    }

    private void setupActionBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void attachTabletFragments() {
        final TimelineFragment timelineFragment = findOrCreateTimelineFragment(R.id.contentFrame_list);
        final TweetDetailFragment tweetDetailFragment = findOrCreateTweetDetailFragmentForTablet();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame_list, timelineFragment)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame_detail, tweetDetailFragment)
                .commit();
    }

    private void attachPhoneFragments() {
        final TimelineFragment timelineFragment = findOrCreateTimelineFragment(R.id.contentFrame);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame, timelineFragment)
                .commit();
    }

    @NonNull
    private TimelineFragment findOrCreateTimelineFragment(@IdRes int fragmentId) {
        TimelineFragment timelineFragment = (TimelineFragment) getSupportFragmentManager()
                .findFragmentById(fragmentId);

        if (timelineFragment == null) {
            timelineFragment = TimelineFragment.newInstance();
        }

        return timelineFragment;
    }

    @NonNull
    private TweetDetailFragment findOrCreateTweetDetailFragmentForTablet() {
        TweetDetailFragment tweetDetailFragment = (TweetDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame_detail);

        if (tweetDetailFragment == null) {
            tweetDetailFragment = TweetDetailFragment.newInstance();
        }

        return tweetDetailFragment;
    }

    private void checkUserSession() {
        // TODO add user session check
        if (false) {
            startActivity(LoginActivity.newIntent(this));
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
