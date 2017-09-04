package sokolov.dunkancards.domain.boundary.card;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;

public interface CardsRepository {
    List<Card> getCardsByCategoryId(int id);
}
