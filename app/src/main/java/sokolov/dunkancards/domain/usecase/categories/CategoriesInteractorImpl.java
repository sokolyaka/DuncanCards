package sokolov.dunkancards.domain.usecase.categories;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.boundary.card.CardsRepository;
import sokolov.dunkancards.domain.boundary.category.CategoriesRepository;
import sokolov.dunkancards.domain.boundary.i18n.StringsRepository;
import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;
import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModelFromDataModel;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;
    private final CardsRepository cardsRepository;
    private final SettingsRepository settingsRepository;
    private final StringsRepository stringsRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository, CardsRepository cardsRepository, SettingsRepository settingsRepository, StringsRepository stringsRepository) {
        this.categoryRepository = categoryRepository;
        this.cardsRepository = cardsRepository;
        this.settingsRepository = settingsRepository;
        this.stringsRepository = stringsRepository;
    }

    @Override
    public List<CategoryDisplayModel> loadCategories() {
        List<Category> dataModels = categoryRepository.getAllCategories();
        List<CategoryDisplayModel> viewModels = new ArrayList<>();
        for (Category model : dataModels) {
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

    @Override
    public String getTitle() {
        return
                stringsRepository.getCategoriesTitle(
                        settingsRepository.getCurrentLanguage());
    }
}
