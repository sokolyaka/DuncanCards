package sokolov.dunkancards.cards.presenter;

import sokolov.dunkancards.cards.interactor.CardsInteractor;
import sokolov.dunkancards.cards.view.CardsView;

public class CardsPresenterImpl implements CardsPresenter {
    private final CardsView cardsView;
    private final CardsInteractor cardsInteractor;

    public CardsPresenterImpl(CardsView cardsView, CardsInteractor cardsInteractor) {
        this.cardsView = cardsView;
        this.cardsInteractor = cardsInteractor;
    }

    @Override
    public void onCreate() {
        cardsView.showCards(
                cardsInteractor.loadCards());
    }
}
