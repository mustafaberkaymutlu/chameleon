package net.epictimes.owl;

import android.app.Activity;
import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import net.epictimes.owl.di.DaggerSingletonComponent;
import net.epictimes.owl.di.SingletonComponent;
import net.epictimes.owl.util.ReleaseLoggingTree;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class OwlApplication extends Application implements HasActivityInjector {
    private RefWatcher refWatcher;
    private SingletonComponent singletonComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);

        Fabric.with(this, new Crashlytics());

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

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    public SingletonComponent getSingletonComponent() {
        return singletonComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
