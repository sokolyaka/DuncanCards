package sokolov.dunkancards.cards.model;

import java.util.Arrays;
import java.util.List;

public class CardsInMemoryRepository implements CardsRepository {

    private final List<? extends CardModel> models;

    public CardsInMemoryRepository() {
        models =
                Arrays.asList(
                        new CardModelImpl(0, 1, "stub_card_img.png", "Tractor"),
                        new CardModelImpl(1, 1, "stub_card_img.png", "Bus"),
                        new CardModelImpl(2, 1, "stub_card_img.png", "Train"),
                        new CardModelImpl(3, 1, "stub_card_img.png", "auto"),
                        new CardModelImpl(4, 1, "stub_card_img.png", "crane"),
                        new CardModelImpl(5, 1, "stub_card_img.png", "excavator")
                );
    }

    @Override
    public List<CardModel> getCardsByCategoryId(int id) {
        return (List<CardModel>) models;
    }
}
