package sokolov.dunkancards.categories.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.categories.view.CategoryViewModel;
import sokolov.dunkancards.repository.CategoriesRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoriesInteractorImplTest {

    private CategoriesInteractorImpl categoriesInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesRepository categoriesRepository;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoryViewModel categoryViewModel;

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
        categoriesInteractor.selectedCategory(categoryViewModel);
        verify(categoriesRepository, times(1)).saveLastSelectedCategory(categoryViewModel.id());
    }
}