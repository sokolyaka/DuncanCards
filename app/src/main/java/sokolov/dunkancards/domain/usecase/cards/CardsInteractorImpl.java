package sokolov.dunkancards.domain.usecase.cards;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.domain.boundary.card.CardsRepository;
import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;
import sokolov.dunkancards.domain.entity.card.Card;
import sokolov.dunkancards.view.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.view.cards.view.CardDisplayModel;

public class CardsInteractorImpl implements CardsInteractor {

    private final CardsRepository cardsRepository;
    private final SettingsRepository settingsRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository, SettingsRepository settingsRepository) {
        this.cardsRepository = cardsRepository;
        this.settingsRepository = settingsRepository;
    }

    @Override
    public List<CardDisplayModel> loadCards(CategoryDisplayModel category) {
        List<Card> models =
                cardsRepository
                        .getCardsByCategoryId(
                                category.id());
        List<CardDisplayModel> views = new ArrayList<>();

        for (Card model : models) {
            views.add(
                    new CardDisplayFormModel(
                            model,
                            settingsRepository.getCurrentLanguage()));
        }

        return views;
    }
}
