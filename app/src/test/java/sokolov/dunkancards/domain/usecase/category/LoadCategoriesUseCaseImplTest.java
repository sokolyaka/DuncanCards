package sokolov.dunkancards.domain.usecase.category;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import sokolov.dunkancards.data.repository.mock.MockCategoriesRepository;
import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.domain.usecase.categories.LoadCategoriesUseCase;
import sokolov.dunkancards.domain.usecase.categories.LoadLoadCategoriesUseCaseImpl;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static sokolov.dunkancards.view.categories.CategoriesTestData.TRANSPORT_CATEGORY;

public class LoadCategoriesUseCaseImplTest {

    private LoadCategoriesUseCase loadCategoriesUseCase;

    @Before
    public void setUp() {
        loadCategoriesUseCase =
                new LoadLoadCategoriesUseCaseImpl(
                        new MockCategoriesRepository());
    }

    @Test
    public void testLoadCategories() {
        loadCategoriesUseCase.execute(new LoadCategoriesUseCase.Callback() {

            @Override
            public void onSuccess(List<Category> categories) {
                assertEquals(
                        singletonList(TRANSPORT_CATEGORY),
                        categories);

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

}