package sokolov.dunkancards.cards.interactor;

import java.util.List;

import sokolov.dunkancards.cards.view.CardDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;

public interface CardsInteractor {
    List<CardDisplayModel> loadCards(CategoryDisplayModel category);
}
