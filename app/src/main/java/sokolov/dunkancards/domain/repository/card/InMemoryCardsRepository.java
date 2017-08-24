package sokolov.dunkancards.domain.repository.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.domain.entity.card.CardModelImpl;

import static sokolov.dunkancards.domain.repository.category.CategoriesConstants.TRANSPORT_ID;

public class InMemoryCardsRepository implements CardsRepository {

    private static final Map<Integer, Map<String, String>> TITLES;
    static {
        TITLES = new HashMap<>();

        Map<String, String> truck = new HashMap<>();
        truck.put("en", "Truck");
        truck.put("ua", "вантажівка");
        truck.put("ru", "грузовик");
        TITLES.put(0, truck);

        Map<String, String> ambulance = new HashMap<>();
        ambulance.put("en", "Ambulance");
        ambulance.put("ua", "Швидка допомога");
        ambulance.put("ru", "скорая помощь");
        TITLES.put(1, ambulance);

        Map<String, String> car = new HashMap<>();
        car.put("en", "Car");
        car.put("ua", "Машина");
        car.put("ru", "автомобиль");
        TITLES.put(2, car);

        Map<String, String> bicycle = new HashMap<>();
        bicycle.put("en", "Bicycle");
        bicycle.put("ua", "Велосипед");
        bicycle.put("ru", "Велосипед");
        TITLES.put(3, bicycle);

        Map<String, String> bus = new HashMap<>();
        bus.put("en", "Bus");
        bus.put("ua", "Автобус");
        bus.put("ru", "Автобус");
        TITLES.put(4, bus);

        Map<String, String> motorcycle = new HashMap<>();
        motorcycle.put("en", "Motorcycle");
        motorcycle.put("ua", "Мотоцикл");
        motorcycle.put("ru", "Мотоцикл");
        TITLES.put(5, motorcycle);

        Map<String, String> police = new HashMap<>();
        police.put("en", "Police");
        police.put("ua", "Поліція");
        police.put("ru", "Полиция");
        TITLES.put(6, police);

        Map<String, String> train = new HashMap<>();
        train.put("en", "Train");
        train.put("ua", "Потяг");
        train.put("ru", "Поезд");
        TITLES.put(7, train);

        Map<String, String> trolleybus = new HashMap<>();
        trolleybus.put("en", "Trolleybus");
        trolleybus.put("ua", "Тролейбус");
        trolleybus.put("ru", "троллейбус");
        TITLES.put(8, trolleybus);

        Map<String, String> fireTruck = new HashMap<>();
        fireTruck.put("en", "Fire truck");
        fireTruck.put("ua", "Пожежна машина");
        fireTruck.put("ru", "Пожарная машина");
        TITLES.put(9, fireTruck);
    }

    private static final List<? extends Card> models;
    static {
        models =
                Arrays.asList(
                        new CardModelImpl(0, TRANSPORT_ID, "transport/truck.jpg", TITLES.get(0)),
                        new CardModelImpl(1, TRANSPORT_ID, "transport/ambulance.jpg", TITLES.get(1)),
                        new CardModelImpl(2, TRANSPORT_ID, "transport/auto.jpg", TITLES.get(2)),
                        new CardModelImpl(3, TRANSPORT_ID, "transport/bicycle.jpg", TITLES.get(3)),
                        new CardModelImpl(4, TRANSPORT_ID, "transport/bus.jpg", TITLES.get(4)),
                        new CardModelImpl(5, TRANSPORT_ID, "transport/motorcycle.jpg", TITLES.get(5)),
                        new CardModelImpl(6, TRANSPORT_ID, "transport/police.jpg", TITLES.get(6)),
                        new CardModelImpl(7, TRANSPORT_ID, "transport/tram.jpg", TITLES.get(7)),
                        new CardModelImpl(8, TRANSPORT_ID, "transport/trolleybus.jpg", TITLES.get(8)),
                        new CardModelImpl(9, TRANSPORT_ID, "transport/fire truck.jpg", TITLES.get(9)));
    }

    @Override
    public List<Card> getCardsByCategoryId(int id) {
        List<Card> result = new ArrayList<>();
        for (Card model : models) {
            if (model.categoryId() == id) {
                result.add(model);
            }
        }
        return result;
    }
}
