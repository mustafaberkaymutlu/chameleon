package net.epictimes.chameleon.data.local;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.UsersDataSource;
import net.epictimes.chameleon.util.AppExecutors;

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
