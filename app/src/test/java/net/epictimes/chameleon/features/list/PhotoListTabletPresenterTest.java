package net.epictimes.chameleon.features.list;

import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.features.detail.PhotoDetailContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class PhotoListTabletPresenterTest {

    private PhotoListTabletPresenter presenter;

    @Mock
    private PhotoListContract.View view;

    @Mock
    private PhotoListContract.Presenter photoListPresenter;

    @Mock
    private PhotoDetailContract.Presenter photoDetailPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(view.isActive()).thenReturn(true);

        presenter = new PhotoListTabletPresenter();
        presenter.setPhotoListPresenter(photoListPresenter);
        presenter.setPhotoDetailPresenter(photoDetailPresenter);
    }

    @Test
    public void onPhotoSelected_shouldLoadDetail() {
        final Photo photo = new Photo(1, 10, "a");

        presenter.onPhotoSelected(photo);

        verify(photoDetailPresenter, times(1)).setPhotoId(1);
        verify(photoDetailPresenter, times(1)).loadPhoto();
    }

    @Test
    public void refresh_shouldClearDetail() {
        presenter.onRefresh();

        verify(photoListPresenter, times(1)).onRefresh();
        verify(photoDetailPresenter, times(1)).setPhotoId(-1);
        verify(photoDetailPresenter, times(1)).loadPhoto();
    }

}
