package sokolov.dunkancards.home.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import sokolov.dunkancards.home.interactor.CategoriesInteractor;
import sokolov.dunkancards.home.view.CategoriesView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoriesPresenterImplTest {

    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesView categoriesView;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesInteractor categoriesInteractor;
    private CategoriesPresenterImpl categoriesPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoriesPresenter = new CategoriesPresenterImpl(
                categoriesView,
                categoriesInteractor);
    }

    @Test
    public void testOnViewShow() {
        categoriesPresenter.onViewShow();
        verify(categoriesInteractor, times(1))
                .loadCategories();
        verify(categoriesView, times(1))
                .setCategories(new ArrayList<String>());
    }

}