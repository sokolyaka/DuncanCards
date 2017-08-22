package sokolov.dunkancards.categories.interactor;

import org.junit.Before;
import org.junit.Test;

import sokolov.dunkancards.categories.model.CategoryModelImpl;
import sokolov.dunkancards.categories.view.CategoryDisplayModelFromDataModel;
import sokolov.dunkancards.repository.MockCardsRepository;
import sokolov.dunkancards.repository.MockCategoriesRepository;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;

public class CategoriesInteractorImplTest {

    private CategoriesInteractor categoriesInteractor;

    @Before
    public void setUp() {
        categoriesInteractor =
                new CategoriesInteractorImpl(
                        new MockCategoriesRepository(),
                        new MockCardsRepository());
    }

    @Test
    public void testLoadCategories() {
        assertEquals(
                singletonList(
                        new CategoryDisplayModelFromDataModel(
                                new CategoryModelImpl(
                                        TRANSPORT_ID,
                                        "Title",
                                        "previewPath"),
                                10)),
                categoriesInteractor
                        .loadCategories());
    }
}