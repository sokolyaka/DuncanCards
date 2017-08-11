package sokolov.dunkancards.categories.interactor;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.categories.view.CategoryViewModel;
import sokolov.dunkancards.categories.view.CategoryViewModelFromDataModel;
import sokolov.dunkancards.repository.CategoriesRepository;
import sokolov.dunkancards.repository.CategoryModel;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    @Override
    public List<CategoryViewModel> loadCategories() {
        List<CategoryModel> dataModels = categoryRepository.getAllCategories();
        List<CategoryViewModel> viewModels = new ArrayList<>();
        for (CategoryModel model : dataModels) {
            viewModels.add(new CategoryViewModelFromDataModel(model));
        }
        return viewModels;
    }

    @Override
    public void selectedCategory(CategoryViewModel categoryViewModel) {
        categoryRepository.saveLastSelectedCategory(categoryViewModel.id());
    }
}
