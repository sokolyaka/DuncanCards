package sokolov.dunkancards.domain.boundary.category;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.Category;

public interface CategoriesRepository {

    List<Category> getAllCategories();

}
