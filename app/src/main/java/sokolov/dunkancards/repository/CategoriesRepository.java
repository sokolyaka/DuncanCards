package sokolov.dunkancards.repository;

import java.util.List;

import sokolov.dunkancards.categories.view.CategoryViewModel;

public interface CategoriesRepository {

    List<CategoryModel> getAllCategories();
}
