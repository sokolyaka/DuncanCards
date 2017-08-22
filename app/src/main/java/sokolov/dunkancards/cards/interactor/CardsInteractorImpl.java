package sokolov.dunkancards.cards.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.cards.view.CardDisplayModel;
import sokolov.dunkancards.cards.model.CardModel;
import sokolov.dunkancards.cards.model.CardsRepository;
import sokolov.dunkancards.categories.model.CategoriesRepository;

public class CardsInteractorImpl implements CardsInteractor {
    private final CardsRepository cardsRepository;
    private final CategoriesRepository categoryRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository, CategoriesRepository categoryRepository) {
        this.cardsRepository = cardsRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CardDisplayModel> loadCards() {
        List<CardModel> models =
                cardsRepository.getCardsByCategoryId(
                        categoryRepository.getLastSelectedCategoryId());
        List<CardDisplayModel> views = new ArrayList<>();

        for (CardModel model : models) {
            views.add(new CardDisplayFormModel(model));
        }

        return views;
    }
}
