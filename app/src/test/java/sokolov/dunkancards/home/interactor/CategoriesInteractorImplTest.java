package sokolov.dunkancards.home.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.repository.CategoriesRepository;

public class CategoriesInteractorImplTest {

    private CategoriesInteractorImpl categoriesInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesRepository categoriesRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categoriesInteractor =
                new CategoriesInteractorImpl(categoriesRepository);
    }

    @Test
    public void testLoadCategories() {
        categoriesInteractor.loadCategories();
        Mockito
                .verify(categoriesRepository, Mockito.times(1))
                .getAllCategories();
    }
}