package sokolov.dunkancards.categories.interactor;

import org.junit.Before;
import org.junit.Test;

import sokolov.dunkancards.categories.view.CategoryDisplayModelFromDataModel;
import sokolov.dunkancards.repository.MockCardsRepository;
import sokolov.dunkancards.repository.MockCategoriesRepository;
import sokolov.dunkancards.repository.MockSettingsRepository;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static sokolov.dunkancards.categories.CategoriesTestData.TRANSPORT_CATEGORY;

public class CategoriesInteractorImplTest {

    private CategoriesInteractor categoriesInteractor;

    @Before
    public void setUp() {
        categoriesInteractor =
                new CategoriesInteractorImpl(
                        new MockCategoriesRepository(),
                        new MockCardsRepository(),
                        new MockSettingsRepository("en"));
    }

    @Test
    public void testLoadCategories() {
        assertEquals(
                singletonList(
                        new CategoryDisplayModelFromDataModel(
                                TRANSPORT_CATEGORY,
                                10,
                                "en")),
                categoriesInteractor
                        .loadCategories());
    }
}