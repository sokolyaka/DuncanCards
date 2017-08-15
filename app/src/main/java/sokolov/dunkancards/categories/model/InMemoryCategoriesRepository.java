package sokolov.dunkancards.categories.model;

import java.util.Arrays;
import java.util.List;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<? extends CategoryModel> categories;
    private int lastSelectedCategoryId;

    public InMemoryCategoriesRepository() {
        categories = Arrays.asList(
                new CategoryModelImpl(0, "Transport", "stub_category_img.png", 11),
                new CategoryModelImpl(1, "Animals", "stub_category_img.png", 12),
                new CategoryModelImpl(2, "Numbers", "stub_category_img.png", 13),
                new CategoryModelImpl(3, "Vegetables", "stub_category_img.png", 14),
                new CategoryModelImpl(4, "Fruits", "", 15));

        lastSelectedCategoryId = -1;
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categories;
    }

    @Override
    public void saveLastSelectedCategory(int id) {
        lastSelectedCategoryId = id;
    }

    @Override
    public int getLastSelectedCategoryId() {
        return lastSelectedCategoryId;
    }
}
