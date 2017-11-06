package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;

public class UsersRepository implements UsersDataSource {

    @NonNull
    private final UsersDataSource usersLocalDataSource;

    public UsersRepository(@NonNull UsersDataSource usersLocalDataSource) {
        this.usersLocalDataSource = usersLocalDataSource;
    }

}
