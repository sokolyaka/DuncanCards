package sokolov.dunkancards.repository;

import java.util.Arrays;
import java.util.List;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<? extends CategoryModel> categories;

    public InMemoryCategoriesRepository() {
        categories = Arrays.asList(
                new CategoryModelImpl("Transport", "stub_category_img.png", 11),
                new CategoryModelImpl("Animals", "stub_category_img.png", 12),
                new CategoryModelImpl("Numbers", "stub_category_img.png", 13),
                new CategoryModelImpl("Vegetables", "stub_category_img.png", 14),
                new CategoryModelImpl("Fruits", "", 15));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categories;
    }
}
