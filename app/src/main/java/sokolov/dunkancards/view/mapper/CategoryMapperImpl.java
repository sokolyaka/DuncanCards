package sokolov.dunkancards.view.mapper;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.boundary.card.CardsRepository;
import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;
import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModelFromDataModel;

public class CategoryMapperImpl implements CategoryMapper {

    private final SettingsRepository settingsRepository;
    private final CardsRepository cardsRepository;

    public CategoryMapperImpl(SettingsRepository settingsRepository, CardsRepository cardsRepository) {
        this.settingsRepository = settingsRepository;
        this.cardsRepository = cardsRepository;
    }

    @Override
    public List<CategoryDisplayModel> toDisplayModel(List<Category> categories) {
        List<CategoryDisplayModel> viewModels = new ArrayList<>();
        for (Category model : categories) {
            viewModels.add(
                    new CategoryDisplayModelFromDataModel(
                            model,
                            cardsRepository
                                    .getCardsByCategoryId(
                                            model.id())
                                    .size(),
                            settingsRepository.getCurrentLanguage()));
        }
        return viewModels;
    }
}
