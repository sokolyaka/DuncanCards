package sokolov.dunkancards.categories.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.categories.view.CategoryDisplayModelFromDataModel;
import sokolov.dunkancards.categories.model.CategoriesRepository;
import sokolov.dunkancards.categories.model.CategoryModel;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    @Override
    public List<CategoryDisplayModel> loadCategories() {
        List<CategoryModel> dataModels = categoryRepository.getAllCategories();
        List<CategoryDisplayModel> viewModels = new ArrayList<>();
        for (CategoryModel model : dataModels) {
            viewModels.add(new CategoryDisplayModelFromDataModel(model));
        }
        return viewModels;
    }

    @Override
    public void selectedCategory(CategoryDisplayModel categoryDisplayModel) {
        categoryRepository.saveLastSelectedCategory(categoryDisplayModel.id());
    }
}
