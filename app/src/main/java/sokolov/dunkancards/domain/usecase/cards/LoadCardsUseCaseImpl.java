package sokolov.dunkancards.domain.usecase.cards;

import sokolov.dunkancards.domain.boundary.card.CardsRepository;

public class LoadCardsUseCaseImpl implements LoadCardsUseCase {

    private final CardsRepository cardsRepository;
    private final int categoryId;

    public LoadCardsUseCaseImpl(CardsRepository cardsRepository, int categoryId) {
        this.cardsRepository = cardsRepository;
        this.categoryId = categoryId;
    }

    @Override
    public void execute(Callback callback) {
        try {
            callback.onSuccess(
                    cardsRepository
                            .getCardsByCategoryId(
                                    categoryId));
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
