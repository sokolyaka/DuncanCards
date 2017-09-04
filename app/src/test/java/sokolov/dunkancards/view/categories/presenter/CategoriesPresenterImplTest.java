package sokolov.dunkancards.view.categories.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import sokolov.dunkancards.domain.usecase.categories.CategoriesInteractor;
import sokolov.dunkancards.view.categories.view.CategoriesView;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

import static org.mockito.Mockito.verify;

public class CategoriesPresenterImplTest {

    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesView categoriesView;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoryDisplayModel categoryDisplayModel;
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
        verify(categoriesInteractor)
                .loadCategories();
        verify(categoriesView)
                .setCategories(new ArrayList<CategoryDisplayModel>());
        verify(categoriesInteractor)
                .getTitle();
        verify(categoriesView)
                .updateTitle("");
    }

    @Test
    public void testOnCategorySelected() {
        categoriesPresenter.onCategorySelected(categoryDisplayModel);
        verify(categoriesView).launchCategoryView(categoryDisplayModel);
    }
}