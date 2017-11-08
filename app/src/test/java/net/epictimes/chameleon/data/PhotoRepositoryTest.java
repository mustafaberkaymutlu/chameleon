package net.epictimes.chameleon.data;

import net.epictimes.chameleon.data.model.Photo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class PhotoRepositoryTest {

    private static List<Photo> PHOTOS;

    private PhotoRepository repository;

    @Mock
    private PhotoDataSource remoteDataSource;

    @Mock
    private PhotoDataSource localDataSource;

    @Mock
    private PhotoDataSource.LoadPhotosCallback loadPhotosCallback;

    @Mock
    private PhotoDataSource.LoadPhotoCallback loadPhotoCallback;

    @Captor
    private ArgumentCaptor<PhotoDataSource.LoadPhotosCallback> photosCallbackCaptor;

    @Captor
    private ArgumentCaptor<PhotoDataSource.LoadPhotoCallback> photoCallbackCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        repository = new PhotoRepository(remoteDataSource, localDataSource);

        PHOTOS = new ArrayList<Photo>() {{
            add(new Photo(1, 10, "a"));
            add(new Photo(2, 20, "b"));
            add(new Photo(3, 30, "c"));
        }};
    }

    @Test
    public void getPhotos_shouldCacheAfterFirstRemoteCall() {
        repository.getPhotos(loadPhotosCallback); // First call

        verify(localDataSource, times(1)).getPhotos(photosCallbackCaptor.capture());

        // Local data source does not have the data yet..
        photosCallbackCaptor.getValue().onPhotosNotAvailable();

        verify(remoteDataSource, times(1)).getPhotos(photosCallbackCaptor.capture());

        photosCallbackCaptor.getValue().onPhotosLoaded(PHOTOS);

        assertThat(repository.cachedPhotos.size(), is(3));

        repository.getPhotos(loadPhotosCallback); // Second call

        verify(remoteDataSource, times(1))
                .getPhotos(any(PhotoDataSource.LoadPhotosCallback.class));
    }

    @Test
    public void getPhoto_shouldCacheAfterFirstRemoteCall() {
        final Photo photo = new Photo(10, 20, "abc");

        repository.getPhoto(1, loadPhotoCallback); // First call

        verify(localDataSource, times(1)).getPhoto(eq(1), photoCallbackCaptor.capture());

        // Local data source does not have the data yet..
        photoCallbackCaptor.getValue().onPhotoNotAvailable();

        verify(remoteDataSource, times(1)).getPhoto(eq(1), photoCallbackCaptor.capture());

        photoCallbackCaptor.getValue().onPhotoLoaded(photo);

        assertThat(repository.cachedPhotos.size(), is(1));

        repository.getPhoto(1, loadPhotoCallback); // Second call

        verify(remoteDataSource, times(1))
                .getPhoto(anyInt(), any(PhotoDataSource.LoadPhotoCallback.class));
    }

    @Test
    public void getPhotos_shouldCallLocalDataSource() {
        repository.getPhotos(loadPhotosCallback);

        verify(localDataSource, times(1)).getPhotos(any(PhotoDataSource.LoadPhotosCallback.class));
    }

    @Test
    public void getPhoto_shouldLoadPhotoFromLocal() {
        repository.getPhoto(1, loadPhotoCallback);

        verify(localDataSource, times(1)).getPhoto(eq(1), any(PhotoDataSource.LoadPhotoCallback.class));
    }

    @Test
    public void savePhoto_shouldSavePhotoToCacheAndLocal() {
        final Photo photo = new Photo(1, 10, "a");

        repository.savePhoto(photo);

        verify(remoteDataSource, never()).savePhoto(photo);
        verify(localDataSource, times(1)).savePhoto(photo);
        assertThat(repository.cachedPhotos.size(), is(1));
    }

    @Test
    public void deletePhoto_shouldDeletePhotoFromCacheAndLocal() {
        Photo photo = new Photo(1, 2, "a");
        repository.savePhoto(photo);
        assertTrue(repository.cachedPhotos.containsKey(photo.getPhotoId()));

        repository.deletePhoto(photo.getPhotoId());

        verify(remoteDataSource, never()).deletePhoto(photo.getPhotoId());
        verify(localDataSource, times(1)).deletePhoto(photo.getPhotoId());

        assertFalse(repository.cachedPhotos.containsKey(photo.getPhotoId()));
    }

    @Test
    public void deleteAllPhotos_shouldDeletePhotosFromCacheAndLocal() {
        repository.savePhoto(new Photo(5, 50, "e"));
        repository.savePhoto(new Photo(6, 60, "f"));
        repository.savePhoto(new Photo(7, 70, "g"));

        repository.deleteAllPhotos();

        verify(remoteDataSource, never()).deleteAllPhotos();
        verify(localDataSource, times(1)).deleteAllPhotos();

        assertThat(repository.cachedPhotos.size(), is(0));
    }


}
