package sokolov.dunkancards.view.mapper;

import java.util.List;

import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.view.cards.view.CardDisplayModel;

public interface CardsMapper {

    List<CardDisplayModel> toDisplayModel(List<Card> cards);
}
