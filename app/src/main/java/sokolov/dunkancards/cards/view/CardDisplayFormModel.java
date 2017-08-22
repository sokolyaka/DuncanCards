package sokolov.dunkancards.cards.view;

import sokolov.dunkancards.cards.model.CardModel;

public class CardDisplayFormModel implements CardDisplayModel {
    private final CardModel model;

    public CardDisplayFormModel(CardModel model) {

        this.model = model;
    }

    @Override
    public String title() {
        return model.title().toUpperCase();
    }

    @Override
    public String imgPath() {
        return model.imgPath();
    }
}
