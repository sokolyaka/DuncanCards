package sokolov.dunkancards.categories.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.repository.card.CardsRepository;
import sokolov.dunkancards.categories.model.CategoriesRepository;
import sokolov.dunkancards.domain.entity.category.CategoryModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModelFromDataModel;
import sokolov.dunkancards.settings.model.SettingsRepository;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;
    private final CardsRepository cardsRepository;
    private final SettingsRepository settingsRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository, CardsRepository cardsRepository, SettingsRepository settingsRepository) {
        this.categoryRepository = categoryRepository;
        this.cardsRepository = cardsRepository;
        this.settingsRepository = settingsRepository;
    }

    @Override
    public List<CategoryDisplayModel> loadCategories() {
        List<CategoryModel> dataModels = categoryRepository.getAllCategories();
        List<CategoryDisplayModel> viewModels = new ArrayList<>();
        for (CategoryModel model : dataModels) {
            viewModels.add(
                    new CategoryDisplayModelFromDataModel(
                            model,
                            cardsRepository
                                    .getCardsByCategoryId(
                                            model.id())
                                    .size(),
                            settingsRepository.getLanguage()));
        }
        return viewModels;
    }
}
