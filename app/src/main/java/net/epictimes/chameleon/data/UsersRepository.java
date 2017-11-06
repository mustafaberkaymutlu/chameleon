package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;

public class UsersRepository implements UsersDataSource {

    @NonNull
    private final UsersDataSource usersLocalDataSource;

    public UsersRepository(@NonNull UsersDataSource usersLocalDataSource) {
        this.usersLocalDataSource = usersLocalDataSource;
    }

    @Override
    public void getLoggedInUser(@NonNull GetLoggedInUserCallback callback) {
        usersLocalDataSource.getLoggedInUser(callback);
    }

    @Override
    public void isUserLoggedIn(@NonNull IsUserLoggedInCallback callback) {
        usersLocalDataSource.isUserLoggedIn(callback);
    }
}
