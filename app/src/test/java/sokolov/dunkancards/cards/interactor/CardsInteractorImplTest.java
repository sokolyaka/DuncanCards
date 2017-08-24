package sokolov.dunkancards.cards.interactor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.categories.mock.MockIdCategoryDisplay;
import sokolov.dunkancards.mock.repository.MockCardsRepository;
import sokolov.dunkancards.mock.repository.MockSettingsRepository;

import static sokolov.dunkancards.cards.CardsTestData.TRANSPORT_CARD_DISPLAY_MODELS_ENG;
import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;

public class CardsInteractorImplTest {

    private CardsInteractorImpl cardsInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardsInteractor = new CardsInteractorImpl(
                new MockCardsRepository(),
                new MockSettingsRepository("en"));
    }

    @Test
    public void testLoadCards() {
        Assert.assertEquals(
                TRANSPORT_CARD_DISPLAY_MODELS_ENG,
                cardsInteractor
                        .loadCards(
                                new MockIdCategoryDisplay(TRANSPORT_ID)));
    }

}