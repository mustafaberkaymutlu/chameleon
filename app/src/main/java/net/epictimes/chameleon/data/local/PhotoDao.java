package net.epictimes.chameleon.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.epictimes.chameleon.data.model.Photo;

import java.util.List;

@Dao
public interface PhotoDao {

    @Query("SELECT * FROM photos")
    List<Photo> getPhotos();

    @Query("SELECT * FROM photos WHERE photoId = :photoId")
    Photo getPhotoById(Integer photoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhoto(Photo photo);

    @Query("DELETE FROM photos WHERE photoId = :photoId")
    int deletePhotoById(String photoId);

    @Query("DELETE FROM photos")
    void deleteAllPhotos();

}
