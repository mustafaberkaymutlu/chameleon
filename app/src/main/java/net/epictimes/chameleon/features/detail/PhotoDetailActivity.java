package net.epictimes.chameleon.features.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import net.epictimes.chameleon.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class PhotoDetailActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private static final String KEY_PHOTO_ID = "photo_i̇d";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    public static Intent newIntent(@NonNull Context context, int photoId) {
        final Intent intent = new Intent(context, PhotoDetailActivity.class);
        intent.putExtra(KEY_PHOTO_ID, photoId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        final int photoId = getIntent().getIntExtra(KEY_PHOTO_ID, -1);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentFrame, PhotoDetailFragment.newInstance(photoId))
                .commit();
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
