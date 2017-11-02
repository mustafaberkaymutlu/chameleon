package net.epictimes.owl;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class OwlApplication extends Application {
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);

        Fabric.with(this, new Crashlytics());

        initTimber();
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
}
