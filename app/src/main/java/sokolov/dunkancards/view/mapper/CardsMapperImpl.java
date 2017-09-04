package sokolov.dunkancards.view.mapper;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;
import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.view.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.view.cards.view.CardDisplayModel;

public class CardsMapperImpl implements CardsMapper {

    private final SettingsRepository settingsRepository;

    public CardsMapperImpl(SettingsRepository settingsRepository) {this.settingsRepository = settingsRepository;}

    @Override
    public List<CardDisplayModel> toDisplayModel(List<Card> cards) {
        List<CardDisplayModel> views = new ArrayList<>();

        for (Card model : cards) {
            views.add(
                    new CardDisplayFormModel(
                            model,
                            settingsRepository.getCurrentLanguage()));
        }
        return views;
    }
}
