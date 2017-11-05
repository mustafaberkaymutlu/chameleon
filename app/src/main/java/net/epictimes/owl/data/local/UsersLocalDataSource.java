package net.epictimes.owl.data.local;

import android.support.annotation.NonNull;

import net.epictimes.owl.data.UsersDataSource;
import net.epictimes.owl.util.AppExecutors;

public class UsersLocalDataSource implements UsersDataSource {
    private final UserDao userDao;
    private final AppExecutors appExecutors;

    public UsersLocalDataSource(UserDao userDao, AppExecutors appExecutors) {
        this.userDao = userDao;
        this.appExecutors = appExecutors;
    }

    @Override
    public void getLoggedInUser(@NonNull GetLoggedInUserCallback callback) {
        appExecutors.diskIo().execute(() -> callback.onUserLoaded(userDao.getLoggedInUser()));
    }

    @Override
    public void isUserLoggedIn(@NonNull IsUserLoggedInCallback callback) {
        appExecutors.diskIo().execute(() -> callback.onResult(userDao.isUserLoggedIn()));
    }
}
