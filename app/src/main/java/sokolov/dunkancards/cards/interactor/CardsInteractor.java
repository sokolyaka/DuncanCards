package sokolov.dunkancards.cards.interactor;

import java.util.List;

import sokolov.dunkancards.cards.view.CardDisplayModel;

public interface CardsInteractor {
    List<CardDisplayModel> loadCards();
}
