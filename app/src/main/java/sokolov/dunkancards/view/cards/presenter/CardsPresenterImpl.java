package sokolov.dunkancards.view.cards.presenter;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.domain.usecase.cards.LoadCardsUseCase;
import sokolov.dunkancards.view.cards.view.CardsView;
import sokolov.dunkancards.view.mapper.CardsMapper;

public class CardsPresenterImpl implements CardsPresenter {

    private final CardsView cardsView;
    private final LoadCardsUseCase loadCardsUseCase;
    private final CardsMapper cardsMapper;

    public CardsPresenterImpl(CardsView cardsView, LoadCardsUseCase loadCardsUseCase, CardsMapper cardsMapper) {
        this.cardsView = cardsView;
        this.loadCardsUseCase = loadCardsUseCase;
        this.cardsMapper = cardsMapper;
    }

    @Override
    public void onCreate() {
        loadCardsUseCase.execute(
                new LoadCardsUseCase.Callback() {

                    @Override
                    public void onSuccess(List<Card> cards) {
                        cardsView.showCards(
                                cardsMapper.toDisplayModel(
                                        cards));
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

    }
}
