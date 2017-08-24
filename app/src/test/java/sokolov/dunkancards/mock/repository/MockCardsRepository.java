package sokolov.dunkancards.mock.repository;

import java.util.List;

import sokolov.dunkancards.cards.CardsTestData;
import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.domain.repository.card.CardsRepository;


public class MockCardsRepository implements CardsRepository {
    @Override
    public List<Card> getCardsByCategoryId(int id) {
        return (List<Card>) CardsTestData.TRANSPORT_CARD_MODELS;
    }
}
