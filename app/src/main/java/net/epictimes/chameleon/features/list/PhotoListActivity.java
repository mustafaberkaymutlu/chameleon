package net.epictimes.chameleon.features.list;

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

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.di.IsTablet;
import net.epictimes.chameleon.features.detail.PhotoDetailFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class PhotoListActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private static final String CURRENT_TASK_ID_KEY = "key_current_task_i̇d";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @IsTablet
    @Inject
    boolean isTablet;

    private String tweetId;

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, PhotoListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        setupActionBar();

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
        final PhotoListFragment photoListFragment = findOrCreateTimelineFragment(R.id.contentFrame_list);
        final PhotoDetailFragment photoDetailFragment = findOrCreateTweetDetailFragmentForTablet();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame_list, photoListFragment)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame_detail, photoDetailFragment)
                .commit();
    }

    private void attachPhoneFragments() {
        final PhotoListFragment photoListFragment = findOrCreateTimelineFragment(R.id.contentFrame);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame, photoListFragment)
                .commit();
    }

    @NonNull
    private PhotoListFragment findOrCreateTimelineFragment(@IdRes int fragmentId) {
        PhotoListFragment photoListFragment = (PhotoListFragment) getSupportFragmentManager()
                .findFragmentById(fragmentId);

        if (photoListFragment == null) {
            photoListFragment = PhotoListFragment.newInstance();
        }

        return photoListFragment;
    }

    @NonNull
    private PhotoDetailFragment findOrCreateTweetDetailFragmentForTablet() {
        PhotoDetailFragment photoDetailFragment = (PhotoDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame_detail);

        if (photoDetailFragment == null) {
            photoDetailFragment = PhotoDetailFragment.newInstance();
        }

        return photoDetailFragment;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
