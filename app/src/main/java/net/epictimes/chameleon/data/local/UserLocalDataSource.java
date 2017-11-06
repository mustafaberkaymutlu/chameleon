package net.epictimes.chameleon.data.local;

import net.epictimes.chameleon.data.UserDataSource;
import net.epictimes.chameleon.util.AppExecutors;

public class UserLocalDataSource implements UserDataSource {
    private final UserDao userDao;
    private final AppExecutors appExecutors;

    public UserLocalDataSource(UserDao userDao, AppExecutors appExecutors) {
        this.userDao = userDao;
        this.appExecutors = appExecutors;
    }

}
