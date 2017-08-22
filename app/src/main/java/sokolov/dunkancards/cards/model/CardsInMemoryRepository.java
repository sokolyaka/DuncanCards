package sokolov.dunkancards.cards.model;

import java.util.Arrays;
import java.util.List;

public class CardsInMemoryRepository implements CardsRepository {

    private final List<? extends CardModel> models;

    public CardsInMemoryRepository() {
        models =
                Arrays.asList(
                        new CardModelImpl(0, 1, "transport/truck.jpg", "Truck"),
                        new CardModelImpl(1, 1, "transport/ambulance.jpg", "Ambulance"),
                        new CardModelImpl(2, 1, "transport/auto.jpg", "Auto"),
                        new CardModelImpl(3, 1, "transport/bicycle.jpg", "Bicycle"),
                        new CardModelImpl(4, 1, "transport/bus.jpg", "Bus"),
                        new CardModelImpl(5, 1, "transport/motorcycle.jpg", "Motorcycle"),
                        new CardModelImpl(6, 1, "transport/police.jpg", "Police"),
                        new CardModelImpl(7, 1, "transport/tram.jpg", "Tram"),
                        new CardModelImpl(8, 1, "transport/trolleybus.jpg", "Trolleybus"),
                        new CardModelImpl(9, 1, "transport/fire truck.jpg", "Fire truck")
                );
    }

    @Override
    public List<CardModel> getCardsByCategoryId(int id) {
        return (List<CardModel>) models;
    }
}
