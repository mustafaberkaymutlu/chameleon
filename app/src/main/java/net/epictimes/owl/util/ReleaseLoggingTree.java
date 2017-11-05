package net.epictimes.owl.util;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

public class ReleaseLoggingTree extends Timber.Tree {
    @Override
    protected boolean isLoggable(String tag, int priority) {
        return priority >= Log.ERROR;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable throwable) {
        Crashlytics.log(priority, tag, message);

        if (throwable != null) {
            Crashlytics.logException(throwable);
        }
    }
}