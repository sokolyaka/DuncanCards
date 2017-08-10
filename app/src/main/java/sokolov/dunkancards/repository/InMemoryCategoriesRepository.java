package sokolov.dunkancards.repository;

import java.util.Arrays;
import java.util.List;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<String> categories;

    public InMemoryCategoriesRepository() {
        categories = Arrays.asList("Transport", "Animals", "Numbers", "Vegetables", "Fruits");
    }

    @Override
    public List<String> getAllCategories() {
        return categories;
    }
}
