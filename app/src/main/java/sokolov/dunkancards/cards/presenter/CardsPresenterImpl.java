package sokolov.dunkancards.cards.presenter;

import sokolov.dunkancards.cards.interactor.CardsInteractor;
import sokolov.dunkancards.cards.view.CardsView;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;

public class CardsPresenterImpl implements CardsPresenter {
    private final CardsView cardsView;
    private final CardsInteractor cardsInteractor;

    public CardsPresenterImpl(CardsView cardsView, CardsInteractor cardsInteractor) {
        this.cardsView = cardsView;
        this.cardsInteractor = cardsInteractor;
    }

    @Override
    public void onCreate(CategoryDisplayModel category) {
        cardsView.showCards(
                cardsInteractor.loadCards(category));
    }
}
