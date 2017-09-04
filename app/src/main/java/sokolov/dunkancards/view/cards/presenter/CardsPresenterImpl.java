package sokolov.dunkancards.view.cards.presenter;

import sokolov.dunkancards.domain.usecase.cards.CardsInteractor;
import sokolov.dunkancards.view.cards.view.CardsView;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

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
