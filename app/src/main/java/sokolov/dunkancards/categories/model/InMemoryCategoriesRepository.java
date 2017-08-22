package sokolov.dunkancards.categories.model;

import java.util.Arrays;
import java.util.List;

import static sokolov.dunkancards.categories.model.CategoriesConstants.*;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<? extends CategoryModel> categories;

    public InMemoryCategoriesRepository() {
        categories = Arrays.asList(
                new CategoryModelImpl(TRANSPORT_ID, "Transport", "stub_category_img.png"),
                new CategoryModelImpl(ANIMALS_ID, "Animals", "stub_category_img.png"),
                new CategoryModelImpl(NUMBERS_ID, "Numbers", "stub_category_img.png"),
                new CategoryModelImpl(VEGETABLES_ID, "Vegetables", "stub_category_img.png"),
                new CategoryModelImpl(FRUITS_ID, "Fruits", ""));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categories;
    }
}
