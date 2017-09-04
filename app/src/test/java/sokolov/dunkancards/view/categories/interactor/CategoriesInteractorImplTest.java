package sokolov.dunkancards.view.categories.interactor;

import org.junit.Before;
import org.junit.Test;

import sokolov.dunkancards.domain.usecase.categories.CategoriesInteractorImpl;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModelFromDataModel;
import sokolov.dunkancards.data.repository.i18n.InMemoryStringsRepository;
import sokolov.dunkancards.domain.usecase.categories.CategoriesInteractor;
import sokolov.dunkancards.data.repository.mock.MockCardsRepository;
import sokolov.dunkancards.data.repository.mock.MockCategoriesRepository;
import sokolov.dunkancards.data.repository.mock.MockSettingsRepository;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static sokolov.dunkancards.view.categories.CategoriesTestData.TRANSPORT_CATEGORY;

public class CategoriesInteractorImplTest {

    private CategoriesInteractor categoriesInteractor;
    private MockSettingsRepository settingsRepository;

    @Before
    public void setUp() {
        settingsRepository = new MockSettingsRepository("en");
        categoriesInteractor =
                new CategoriesInteractorImpl(
                        new MockCategoriesRepository(),
                        new MockCardsRepository(),
                        settingsRepository,
                        new InMemoryStringsRepository());
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

    @Test
    public void getTitle() throws Exception {
        settingsRepository.saveCurrentLanguage("uk");
        assertEquals(
                "Картки Домана",
                categoriesInteractor.getTitle());
    }

}