package sokolov.dunkancards.domain.repository.category;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.Category;

public interface CategoriesRepository {

    List<Category> getAllCategories();

}
