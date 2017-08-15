package sokolov.dunkancards.cards.model;

import java.util.List;

public interface CardsRepository {
    List<CardModel> getCardsByCategoryId(int id);
}
