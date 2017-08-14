package sokolov.dunkancards.cards.interactor;

import java.util.List;

import sokolov.dunkancards.cards.view.CardViewModel;
import sokolov.dunkancards.repository.CardsRepository;

public class CardsInteractorImpl implements CardsInteractor {
    public CardsInteractorImpl(CardsRepository cardsRepository) {
    }

    @Override
    public List<CardViewModel> loadCards() {
        return null;
    }
}
