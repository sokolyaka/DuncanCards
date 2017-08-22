package sokolov.dunkancards.categories.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.categories.model.CategoriesRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoriesInteractorImplTest {

    private CategoriesInteractorImpl categoriesInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesRepository categoriesRepository;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoryDisplayModel categoryDisplayModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categoriesInteractor =
                new CategoriesInteractorImpl(categoriesRepository);
    }

    @Test
    public void testLoadCategories() {
        categoriesInteractor.loadCategories();
        verify(categoriesRepository, times(1))
                .getAllCategories();
    }

    @Test
    public void testSelectedCategory() {
        categoriesInteractor.selectedCategory(categoryDisplayModel);
        verify(categoriesRepository, times(1)).saveLastSelectedCategory(categoryDisplayModel.id());
    }
}