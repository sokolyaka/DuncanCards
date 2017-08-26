package sokolov.dunkancards.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.domain.entity.card.CardModel;
import sokolov.dunkancards.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.cards.view.CardDisplayModel;

import static sokolov.dunkancards.domain.repository.category.CategoriesConstants.TRANSPORT_ID;

public class CardsTestData {

    public static final Map<Integer, Map<String, String>> TITLES;

    static {
        TITLES = new HashMap<>();

        Map<String, String> truck = new HashMap<>();
        truck.put("en", "Truck");
        truck.put("uk", "вантажівка");
        truck.put("ru", "грузовик");
        TITLES.put(0, truck);

        Map<String, String> ambulance = new HashMap<>();
        ambulance.put("en", "Ambulance");
        ambulance.put("uk", "Швидка допомога");
        ambulance.put("ru", "скорая помощь");
        TITLES.put(1, ambulance);

        Map<String, String> car = new HashMap<>();
        car.put("en", "Car");
        car.put("uk", "Машина");
        car.put("ru", "автомобиль");
        TITLES.put(2, car);

        Map<String, String> bicycle = new HashMap<>();
        bicycle.put("en", "Bicycle");
        bicycle.put("uk", "Велосипед");
        bicycle.put("ru", "Велосипед");
        TITLES.put(3, bicycle);

        Map<String, String> bus = new HashMap<>();
        bus.put("en", "Bus");
        bus.put("uk", "Автобус");
        bus.put("ru", "Автобус");
        TITLES.put(4, bus);

        Map<String, String> motorcycle = new HashMap<>();
        motorcycle.put("en", "Motorcycle");
        motorcycle.put("uk", "Мотоцикл");
        motorcycle.put("ru", "Мотоцикл");
        TITLES.put(5, motorcycle);

        Map<String, String> police = new HashMap<>();
        police.put("en", "Police");
        police.put("uk", "Поліція");
        police.put("ru", "Полиция");
        TITLES.put(6, police);

        Map<String, String> train = new HashMap<>();
        train.put("en", "Train");
        train.put("uk", "Потяг");
        train.put("ru", "Поезд");
        TITLES.put(7, train);

        Map<String, String> trolleybus = new HashMap<>();
        trolleybus.put("en", "Trolleybus");
        trolleybus.put("uk", "Тролейбус");
        trolleybus.put("ru", "троллейбус");
        TITLES.put(8, trolleybus);

        Map<String, String> fireTruck = new HashMap<>();
        fireTruck.put("en", "Fire truck");
        fireTruck.put("uk", "Пожежна машина");
        fireTruck.put("ru", "Пожарная машина");
        TITLES.put(9, fireTruck);
    }

    public static final List<? extends Card> TRANSPORT_CARD_MODELS;

    static {
        TRANSPORT_CARD_MODELS =
                Arrays.asList(
                        new CardModel(0, TRANSPORT_ID, "transport/truck.jpg", TITLES.get(0)),
                        new CardModel(
                                1,
                                TRANSPORT_ID,
                                "transport/ambulance.jpg",
                                TITLES.get(1)),
                        new CardModel(2, TRANSPORT_ID, "transport/auto.jpg", TITLES.get(2)),
                        new CardModel(3, TRANSPORT_ID, "transport/bicycle.jpg", TITLES.get(3)),
                        new CardModel(4, TRANSPORT_ID, "transport/bus.jpg", TITLES.get(4)),
                        new CardModel(
                                5,
                                TRANSPORT_ID,
                                "transport/motorcycle.jpg",
                                TITLES.get(5)),
                        new CardModel(6, TRANSPORT_ID, "transport/police.jpg", TITLES.get(6)),
                        new CardModel(7, TRANSPORT_ID, "transport/tram.jpg", TITLES.get(7)),
                        new CardModel(
                                8,
                                TRANSPORT_ID,
                                "transport/trolleybus.jpg",
                                TITLES.get(8)),
                        new CardModel(
                                9,
                                TRANSPORT_ID,
                                "transport/fire truck.jpg",
                                TITLES.get(9)));
    }

    public static final List<CardDisplayModel> TRANSPORT_CARD_DISPLAY_MODELS_ENG;

    static {
        TRANSPORT_CARD_DISPLAY_MODELS_ENG = new ArrayList<>();

        for (Card model : TRANSPORT_CARD_MODELS) {
            TRANSPORT_CARD_DISPLAY_MODELS_ENG.add(new CardDisplayFormModel(model, "en"));
        }
    }
}
