package sokolov.dunkancards.domain.usecase.cards;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;

public interface LoadCardsUseCase {

    void execute(Callback callback);

    interface Callback {

        void onSuccess(List<Card> cards);

        void onError(Exception e);
    }
}
