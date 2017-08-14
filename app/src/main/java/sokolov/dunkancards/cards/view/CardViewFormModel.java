package sokolov.dunkancards.cards.view;

import sokolov.dunkancards.repository.CardModel;

public class CardViewFormModel implements CardViewModel{
    private final CardModel model;

    public CardViewFormModel(CardModel model) {

        this.model = model;
    }
}
