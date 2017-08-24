package sokolov.dunkancards.mock.repository;

import java.util.List;

import sokolov.dunkancards.cards.CardsTestData;
import sokolov.dunkancards.domain.entity.card.CardModel;
import sokolov.dunkancards.cards.model.CardsRepository;


public class MockCardsRepository implements CardsRepository {
    @Override
    public List<CardModel> getCardsByCategoryId(int id) {
        return (List<CardModel>) CardsTestData.TRANSPORT_CARD_MODELS;
    }
}
