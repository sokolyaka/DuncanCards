package sokolov.dunkancards.cards.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;

public class CardsRepositoryTest {

    private CardsRepository cardsRepository;
    private List<CardModelImpl> transportModels;

    @Before
    public void setUp() {
        cardsRepository = new CardsInMemoryRepository();
        transportModels =
                Arrays.asList(
                        new CardModelImpl(0, TRANSPORT_ID, "transport/truck.jpg", "Truck"),
                        new CardModelImpl(1, TRANSPORT_ID, "transport/ambulance.jpg", "Ambulance"),
                        new CardModelImpl(2, TRANSPORT_ID, "transport/auto.jpg", "Auto"),
                        new CardModelImpl(3, TRANSPORT_ID, "transport/bicycle.jpg", "Bicycle"),
                        new CardModelImpl(4, TRANSPORT_ID, "transport/bus.jpg", "Bus"),
                        new CardModelImpl(5, TRANSPORT_ID, "transport/motorcycle.jpg", "Motorcycle"),
                        new CardModelImpl(6, TRANSPORT_ID, "transport/police.jpg", "Police"),
                        new CardModelImpl(7, TRANSPORT_ID, "transport/tram.jpg", "Tram"),
                        new CardModelImpl(8, TRANSPORT_ID, "transport/trolleybus.jpg", "Trolleybus"),
                        new CardModelImpl(9, TRANSPORT_ID, "transport/fire truck.jpg", "Fire truck")
                );
    }

    @Test
    public void testGetCardsByCategoryId() {
        Assert.assertEquals(
                transportModels,
                cardsRepository
                        .getCardsByCategoryId(
                                TRANSPORT_ID));
    }

}