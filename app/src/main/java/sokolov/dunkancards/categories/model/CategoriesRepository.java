package sokolov.dunkancards.categories.model;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.CategoryModel;

public interface CategoriesRepository {

    List<CategoryModel> getAllCategories();

}
