package net.epictimes.chameleon.features.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @IsTablet
    @Inject
    boolean isTablet;

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, PhotoListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (isTablet) {
            attachTabletFragments();
        } else {
            attachPhoneFragments();
        }
    }

    private void attachTabletFragments() {
        final boolean isContentFrameListEmpty = isFragmentDetached(R.id.contentFrame_list);
        final boolean isContentFrameDetailEmpty = isFragmentDetached(R.id.contentFrame_detail);

        if (isContentFrameListEmpty) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentFrame_list, PhotoListFragment.newInstance())
                    .commit();
        }

        if (isContentFrameDetailEmpty) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentFrame_detail, PhotoDetailFragment.newInstance())
                    .commit();
        }
    }

    private void attachPhoneFragments() {
        final boolean isContentFrameEmpty = isFragmentDetached(R.id.contentFrame);

        if (isContentFrameEmpty) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentFrame, PhotoListFragment.newInstance())
                    .commit();
        }
    }

    private boolean isFragmentDetached(int fragmentId) {
        return getSupportFragmentManager().findFragmentById(fragmentId) == null;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
