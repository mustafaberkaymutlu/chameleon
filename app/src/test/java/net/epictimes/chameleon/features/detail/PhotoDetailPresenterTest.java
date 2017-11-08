package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.model.Photo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class PhotoDetailPresenterTest {

    private PhotoDetailPresenter presenter;

    @Mock
    private PhotoDetailContract.View view;

    @Mock
    private PhotoRepository repository;

    @Captor
    private ArgumentCaptor<PhotoDataSource.LoadPhotoCallback> loadPhotoCallbackCaptor;

    @Captor
    private ArgumentCaptor<Photo> photoArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(view.isActive()).thenReturn(true);

        presenter = new PhotoDetailPresenter(view, repository);
    }

    @Test
    public void loadPhoto_shouldDisplayMissingPhoto() {
        presenter.loadPhoto();

        verify(view, times(1)).showMissingPhoto();
    }

    @Test
    public void loadPhotoWithId_shouldDisplayPhoto() {
        final Photo photo = new Photo(10, 20, "a");

        presenter.setPhotoId(10);
        presenter.loadPhoto();

        verify(repository, times(1)).getPhoto(eq(10), loadPhotoCallbackCaptor.capture());

        loadPhotoCallbackCaptor.getValue().onPhotoLoaded(photo);

        verify(view, times(1)).showPhoto(photoArgumentCaptor.capture());

        assertThat(photoArgumentCaptor.getValue(), is(photo));
    }

    @Test
    public void loadPhotoWithId_shouldDisplayError() {
        presenter.setPhotoId(10);
        presenter.loadPhoto();

        verify(repository, times(1)).getPhoto(eq(10), loadPhotoCallbackCaptor.capture());

        loadPhotoCallbackCaptor.getValue().onPhotoNotAvailable();

        verify(view, times(1)).showErrorDisplayingPhoto();
    }
}
