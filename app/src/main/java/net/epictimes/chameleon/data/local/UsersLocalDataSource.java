package net.epictimes.chameleon.data.local;

import net.epictimes.chameleon.data.UsersDataSource;
import net.epictimes.chameleon.util.AppExecutors;

public class UsersLocalDataSource implements UsersDataSource {
    private final UserDao userDao;
    private final AppExecutors appExecutors;

    public UsersLocalDataSource(UserDao userDao, AppExecutors appExecutors) {
        this.userDao = userDao;
        this.appExecutors = appExecutors;
    }

}
