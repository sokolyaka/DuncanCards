package sokolov.dunkancards.data.repository.mock;

import java.util.List;

import sokolov.dunkancards.data.repository.cards.CardsTestData;
import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.domain.boundary.card.CardsRepository;


public class MockCardsRepository implements CardsRepository {
    @Override
    public List<Card> getCardsByCategoryId(int id) {
        return (List<Card>) CardsTestData.TRANSPORT_CARD_MODELS;
    }
}
