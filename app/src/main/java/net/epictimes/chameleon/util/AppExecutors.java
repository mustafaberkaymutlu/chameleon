package net.epictimes.chameleon.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static final int THREAD_COUNT = 3;

    private final Executor diskIo;
    private final Executor networkIo;
    private final Executor mainThread;

    public AppExecutors(Executor diskIo, Executor networkIo, Executor mainThread) {
        this.diskIo = diskIo;
        this.networkIo = networkIo;
        this.mainThread = mainThread;
    }

    public AppExecutors() {
        this(new DiskIOThreadExecutor(), Executors.newFixedThreadPool(THREAD_COUNT),
                new MainThreadExecutor());
    }

    public Executor diskIo() {
        return diskIo;
    }

    public Executor networkIo() {
        return networkIo;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

    private static class DiskIOThreadExecutor implements Executor {
        private final Executor diskIo;

        DiskIOThreadExecutor() {
            diskIo = Executors.newSingleThreadExecutor();
        }

        @Override
        public void execute(@NonNull Runnable command) {
            diskIo.execute(command);
        }

    }
}
