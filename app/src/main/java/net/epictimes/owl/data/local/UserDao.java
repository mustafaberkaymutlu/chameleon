package net.epictimes.owl.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.epictimes.owl.data.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Query("SELECT * FROM users WHERE userId = :userId")
    User getUserById(String userId);

    @Query("SELECT * FROM users WHERE isLoggedInUser = 'true'")
    User getLoggedInUser();

    @Query("SELECT COUNT(*) FROM users WHERE isLoggedInUser = 'true'")
    boolean isUserLoggedIn();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("DELETE FROM users WHERE userId = :userId")
    int deleteUserById(String userId);

    @Query("DELETE FROM users")
    void deleteAllUsers();

}
