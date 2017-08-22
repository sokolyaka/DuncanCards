package sokolov.dunkancards.categories.model;

import java.util.Arrays;
import java.util.List;

import static sokolov.dunkancards.categories.model.CategoriesConstants.*;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<? extends CategoryModel> categories;
    private int lastSelectedCategoryId;

    public InMemoryCategoriesRepository() {
        categories = Arrays.asList(
                new CategoryModelImpl(TRANSPORT_ID, "Transport", "stub_category_img.png", 11),
                new CategoryModelImpl(ANIMALS_ID, "Animals", "stub_category_img.png", 12),
                new CategoryModelImpl(NUMBERS_ID, "Numbers", "stub_category_img.png", 13),
                new CategoryModelImpl(VEGETABLES_ID, "Vegetables", "stub_category_img.png", 14),
                new CategoryModelImpl(FRUITS_ID, "Fruits", "", 15));

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
