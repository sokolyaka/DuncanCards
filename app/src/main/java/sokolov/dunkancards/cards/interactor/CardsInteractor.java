package sokolov.dunkancards.cards.interactor;

import java.util.List;

import sokolov.dunkancards.cards.view.CardViewModel;

public interface CardsInteractor {
    List<CardViewModel> loadCards();
}
