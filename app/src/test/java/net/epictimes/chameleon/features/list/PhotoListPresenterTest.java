package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.data.PhotoRepository;
import net.epictimes.chameleon.data.model.Photo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class PhotoListPresenterTest {

    private static List<Photo> PHOTOS;

    private PhotoListPresenter presenter;

    @Mock
    private PhotoListContract.View view;

    @Mock
    private PhotoRepository repository;

    @Captor
    private ArgumentCaptor<PhotoDataSource.LoadPhotosCallback> loadPhotosCallbackCaptor;

    @Captor
    private ArgumentCaptor<List<Photo>> photoListArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(view.isActive()).thenReturn(true);

        presenter = new PhotoListPresenter(view, repository);

        PHOTOS = new ArrayList<Photo>() {{
            add(new Photo(1, 10, "a"));
            add(new Photo(2, 20, "b"));
            add(new Photo(2, 30, "c"));
        }};
    }

    @Test
    public void loadAllPhotosFromRepository_shouldDisplaySuccess() {
        presenter.loadPhotos();

        verify(repository, times(1)).getPhotos(loadPhotosCallbackCaptor.capture());

        loadPhotosCallbackCaptor.getValue().onPhotosLoaded(PHOTOS);

        final InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view).setLoadingVisibility(true);
        inOrder.verify(view).setLoadingVisibility(false);

        verify(view, times(1)).showPhotos(photoListArgumentCaptor.capture());

        final List<Photo> result = photoListArgumentCaptor.getValue();
        assertThat(result, is(PHOTOS));
    }

    @Test
    public void loadAllPhotosFromRepository_shouldDisplayFail() {
        presenter.loadPhotos();

        verify(repository, times(1)).getPhotos(loadPhotosCallbackCaptor.capture());

        loadPhotosCallbackCaptor.getValue().onPhotosNotAvailable();

        final InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view).setLoadingVisibility(true);
        inOrder.verify(view).setLoadingVisibility(false);
        inOrder.verify(view).showLoadingPhotosError();
    }

    @Test
    public void refresh_shouldDisplaySuccess() {
        presenter.onRefresh();

        verify(repository, times(1)).refreshPhotos();
        verify(repository, times(1)).getPhotos(loadPhotosCallbackCaptor.capture());

        loadPhotosCallbackCaptor.getValue().onPhotosLoaded(PHOTOS);

        final InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view).setLoadingVisibility(true);
        inOrder.verify(view).setLoadingVisibility(false);

        verify(view, times(1)).showPhotos(photoListArgumentCaptor.capture());

        final List<Photo> result = photoListArgumentCaptor.getValue();
        assertThat(result, is(PHOTOS));
    }

}
