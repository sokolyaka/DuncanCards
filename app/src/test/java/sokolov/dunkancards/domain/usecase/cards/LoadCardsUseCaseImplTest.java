package sokolov.dunkancards.domain.usecase.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.mock.repository.MockCardsRepository;

import static sokolov.dunkancards.data.repository.category.CategoriesConstants.TRANSPORT_ID;
import static sokolov.dunkancards.view.cards.CardsTestData.TRANSPORT_CARD_MODELS;

public class LoadCardsUseCaseImplTest {

    private LoadCardsUseCaseImpl loadCardsUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loadCardsUseCase = new LoadCardsUseCaseImpl(
                new MockCardsRepository(),
                TRANSPORT_ID);
    }

    @Test
    public void testLoadCards() {
        loadCardsUseCase
                .execute(new LoadCardsUseCase.Callback() {

                    @Override
                    public void onSuccess(List<Card> cards) {
                        Assert.assertEquals(TRANSPORT_CARD_MODELS, cards);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

}