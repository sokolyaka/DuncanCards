package sokolov.dunkancards.cards.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.model.CardModel;
import sokolov.dunkancards.cards.model.CardsRepository;
import sokolov.dunkancards.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.cards.view.CardDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;

public class CardsInteractorImpl implements CardsInteractor {
    private final CardsRepository cardsRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public List<CardDisplayModel> loadCards(CategoryDisplayModel category) {
        List<CardModel> models =
                cardsRepository
                        .getCardsByCategoryId(
                                category.id());
        List<CardDisplayModel> views = new ArrayList<>();

        for (CardModel model : models) {
            views.add(new CardDisplayFormModel(model));
        }

        return views;
    }
}
