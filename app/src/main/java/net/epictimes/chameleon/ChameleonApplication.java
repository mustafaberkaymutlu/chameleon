package net.epictimes.chameleon;

import android.app.Activity;
import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import net.epictimes.chameleon.di.DaggerSingletonComponent;
import net.epictimes.chameleon.di.SingletonComponent;
import net.epictimes.chameleon.util.ReleaseLoggingTree;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class ChameleonApplication extends Application implements HasActivityInjector {
    private SingletonComponent singletonComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        Fabric.with(this, new Crashlytics());

        Stetho.initializeWithDefaults(this);

        initTimber();

        initSingletonComponent();
    }

    private void initSingletonComponent() {
        singletonComponent = DaggerSingletonComponent.builder()
                .application(this)
                .build();

        singletonComponent.inject(this);
    }

    private void initTimber() {
        final Timber.Tree tree = BuildConfig.DEBUG
                ? new Timber.DebugTree()
                : new ReleaseLoggingTree();

        Timber.plant(tree);
    }

    public SingletonComponent getSingletonComponent() {
        return singletonComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
