package sokolov.dunkancards.categories.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.cards.model.CardsRepository;
import sokolov.dunkancards.categories.model.CategoriesRepository;
import sokolov.dunkancards.categories.model.CategoryModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModelFromDataModel;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;
    private final CardsRepository cardsRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository, CardsRepository cardsRepository) {
        this.categoryRepository = categoryRepository;
        this.cardsRepository = cardsRepository;
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
                                    .size()));
        }
        return viewModels;
    }
}
