package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.epictimes.chameleon.data.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Query("SELECT * FROM users WHERE userId = :userId")
    User getUserById(String userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("DELETE FROM users WHERE userId = :userId")
    int deleteUserById(String userId);

    @Query("DELETE FROM users")
    void deleteAllUsers();

}
