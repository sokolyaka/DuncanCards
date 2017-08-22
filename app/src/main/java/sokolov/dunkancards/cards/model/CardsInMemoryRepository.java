package sokolov.dunkancards.cards.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;

public class CardsInMemoryRepository implements CardsRepository {

    private final List<? extends CardModel> models;

    public CardsInMemoryRepository() {
        models =
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

    @Override
    public List<CardModel> getCardsByCategoryId(int id) {
        List<CardModel> result = new ArrayList<>();
        for (CardModel model : models) {
            if (model.categoryId() == id) {
                result.add(model);
            }
        }
        return result;
    }
}
