package sokolov.dunkancards.data.repository.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import sokolov.dunkancards.data.repository.card.InMemoryCardsRepository;
import sokolov.dunkancards.domain.boundary.card.CardsRepository;

import static sokolov.dunkancards.data.repository.cards.CardsTestData.TRANSPORT_CARD_MODELS;
import static sokolov.dunkancards.data.repository.category.CategoriesConstants.TRANSPORT_ID;

public class CardsRepositoryTest {

    private CardsRepository cardsRepository;

    @Before
    public void setUp() {
        cardsRepository = new InMemoryCardsRepository();
    }

    @Test
    public void testGetCardsByCategoryId() {
        Assert.assertEquals(
                TRANSPORT_CARD_MODELS,
                cardsRepository
                        .getCardsByCategoryId(
                                TRANSPORT_ID));
    }

    @Test
    public void testNoCardsForCategory() {
        Assert.assertEquals(
                Collections.EMPTY_LIST,
                cardsRepository
                        .getCardsByCategoryId(
                                Integer.MIN_VALUE));
    }

}