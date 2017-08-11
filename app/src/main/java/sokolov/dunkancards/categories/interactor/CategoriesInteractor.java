package sokolov.dunkancards.categories.interactor;

import java.util.List;

import sokolov.dunkancards.categories.view.CategoryViewModel;

public interface CategoriesInteractor {

    List<CategoryViewModel> loadCategories();

    void selectedCategory(CategoryViewModel categoryViewModel);
}
