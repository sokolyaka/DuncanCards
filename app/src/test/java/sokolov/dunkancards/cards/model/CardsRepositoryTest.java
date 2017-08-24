package sokolov.dunkancards.cards.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import sokolov.dunkancards.domain.repository.card.CardsRepository;
import sokolov.dunkancards.domain.repository.card.InMemoryCardsRepository;

import static sokolov.dunkancards.cards.CardsTestData.TRANSPORT_CARD_MODELS;
import static sokolov.dunkancards.domain.repository.category.CategoriesConstants.TRANSPORT_ID;

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