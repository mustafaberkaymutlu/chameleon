package net.epictimes.chameleon.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.epictimes.chameleon.data.model.User;

public interface UsersDataSource {

    interface GetLoggedInUserCallback {

        void onUserLoaded(@Nullable User user);

    }

    interface IsUserLoggedInCallback {

        void onResult(boolean isUserLoggedIn);

    }

    void getLoggedInUser(@NonNull GetLoggedInUserCallback callback);

    void isUserLoggedIn(@NonNull IsUserLoggedInCallback callback);

}
