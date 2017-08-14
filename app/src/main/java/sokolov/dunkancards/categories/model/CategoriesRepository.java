package sokolov.dunkancards.categories.model;

import java.util.List;

public interface CategoriesRepository {

    List<CategoryModel> getAllCategories();

    void saveLastSelectedCategory(int id);

    int getLastSelectedCategoryId();
}
