package sokolov.dunkancards.view.mapper;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.mock.repository.MockSettingsRepository;

import static sokolov.dunkancards.view.cards.CardsTestData.TRANSPORT_CARD_DISPLAY_MODELS_ENG;
import static sokolov.dunkancards.view.cards.CardsTestData.TRANSPORT_CARD_MODELS;

public class CardsMapperImplTest {

    @Test
    public void testToDisplayModel() {
        Assert.assertEquals(
                TRANSPORT_CARD_DISPLAY_MODELS_ENG,
                new CardsMapperImpl(
                        new MockSettingsRepository("en"))
                        .toDisplayModel(
                                (List<Card>) TRANSPORT_CARD_MODELS));
    }

}