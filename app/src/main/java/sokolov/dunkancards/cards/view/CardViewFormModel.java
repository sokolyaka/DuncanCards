package sokolov.dunkancards.cards.view;

import sokolov.dunkancards.cards.model.CardModel;

public class CardViewFormModel implements CardViewModel{
    private final CardModel model;

    public CardViewFormModel(CardModel model) {

        this.model = model;
    }
}
