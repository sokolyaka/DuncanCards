package sokolov.dunkancards.cards.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.model.CardModel;
import sokolov.dunkancards.cards.model.CardsRepository;
import sokolov.dunkancards.cards.view.CardDisplayFormModel;
import sokolov.dunkancards.cards.view.CardDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.settings.model.SettingsRepository;

public class CardsInteractorImpl implements CardsInteractor {

    private final CardsRepository cardsRepository;
    private final SettingsRepository settingsRepository;

    public CardsInteractorImpl(CardsRepository cardsRepository, SettingsRepository settingsRepository) {
        this.cardsRepository = cardsRepository;
        this.settingsRepository = settingsRepository;
    }

    @Override
    public List<CardDisplayModel> loadCards(CategoryDisplayModel category) {
        List<CardModel> models =
                cardsRepository
                        .getCardsByCategoryId(
                                category.id());
        List<CardDisplayModel> views = new ArrayList<>();

        for (CardModel model : models) {
            views.add(
                    new CardDisplayFormModel(
                            model,
                            settingsRepository.getLanguage()));
        }

        return views;
    }
}
