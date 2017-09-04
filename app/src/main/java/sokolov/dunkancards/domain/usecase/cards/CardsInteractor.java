package sokolov.dunkancards.domain.usecase.cards;

import java.util.List;

import sokolov.dunkancards.view.cards.view.CardDisplayModel;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

public interface CardsInteractor {
    List<CardDisplayModel> loadCards(CategoryDisplayModel category);
}
