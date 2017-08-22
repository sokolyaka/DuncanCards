package sokolov.dunkancards.categories.interactor;

import java.util.List;

import sokolov.dunkancards.categories.view.CategoryDisplayModel;

public interface CategoriesInteractor {

    List<CategoryDisplayModel> loadCategories();

    void selectedCategory(CategoryDisplayModel categoryDisplayModel);
}
