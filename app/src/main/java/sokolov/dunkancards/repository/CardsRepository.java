package sokolov.dunkancards.repository;

import java.util.List;

public interface CardsRepository {
    List<CardModel> getCardsByCategory();
}
