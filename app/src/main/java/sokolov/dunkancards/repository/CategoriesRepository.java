package sokolov.dunkancards.repository;

import java.util.List;

public interface CategoriesRepository {

    List<CategoryModel> getAllCategories();

    void saveLastSelectedCategory(int id);

    int getLastSelectedCategoryId();
}
