package sokolov.dunkancards.cards.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.view.CardViewFormModel;
import sokolov.dunkancards.cards.view.CardViewModel;
import sokolov.dunkancards.repository.CardModel;
import sokolov.dunkancards.repository.CardsRepository;
import sokolov.dunkancards.repository.CategoriesRepository;

public class CardsInteractorImpl implements CardsInteractor {
    private final CardsRepository cardsRepository;
    private final CategoriesRepository categoryRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository, CategoriesRepository categoryRepository) {
        this.cardsRepository = cardsRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CardViewModel> loadCards() {
        List<CardModel> models =
                cardsRepository.getCardsByCategoryId(
                        categoryRepository.getLastSelectedCategoryId());
        List<CardViewModel> views = new ArrayList<>();

        for (CardModel model : models) {
            views.add(new CardViewFormModel(model));
        }

        return views;
    }
}
