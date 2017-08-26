package sokolov.dunkancards.domain.repository.category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.domain.entity.category.CategoryModel;

import static sokolov.dunkancards.domain.repository.category.CategoriesConstants.TRANSPORT_ID;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private static final Map<Integer, Map<String, String>> titles;
    static {
        titles = new HashMap<>();

        Map<String, String> transport = new HashMap<>();
        transport.put("en", "transport");
        transport.put("uk", "Транспорт");
        transport.put("ru", "Транспорт");
        titles.put(TRANSPORT_ID, transport);

    }
    private final static List<? extends Category> categories;
    static {
        categories = Arrays.asList(
                new CategoryModel(TRANSPORT_ID, titles.get(TRANSPORT_ID), "stub_category_img.png"));
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categories;
    }
}
