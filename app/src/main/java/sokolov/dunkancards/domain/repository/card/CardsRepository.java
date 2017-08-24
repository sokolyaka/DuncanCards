package sokolov.dunkancards.domain.repository.card;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.CardModel;

public interface CardsRepository {
    List<CardModel> getCardsByCategoryId(int id);
}
