package sokolov.dunkancards.cards.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.view.CardViewFormModel;
import sokolov.dunkancards.cards.view.CardViewModel;
import sokolov.dunkancards.repository.CardModel;
import sokolov.dunkancards.repository.CardsRepository;

public class CardsInteractorImpl implements CardsInteractor {
    private final CardsRepository cardsRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public List<CardViewModel> loadCards() {
        List<CardModel> models = cardsRepository.getCardsByCategory();
        List<CardViewModel> views = new ArrayList<>();

        for (CardModel model : models) {
            views.add(new CardViewFormModel(model));
        }

        return views;
    }
}
