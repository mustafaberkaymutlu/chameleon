package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;

public class UserRepository implements UserDataSource {

    @NonNull
    private final UserDataSource userLocalDataSource;

    public UserRepository(@NonNull UserDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

}
