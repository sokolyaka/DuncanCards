package sokolov.dunkancards.domain.usecase.categories;

import java.util.List;

import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

public interface CategoriesInteractor {

    List<CategoryDisplayModel> loadCategories();

    String getTitle();
}
