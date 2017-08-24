package sokolov.dunkancards.categories.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sokolov.dunkancards.domain.entity.category.CategoryModel;
import sokolov.dunkancards.domain.entity.category.CategoryModelImpl;

import static sokolov.dunkancards.categories.model.CategoriesConstants.*;

public class InMemoryCategoriesRepository implements CategoriesRepository {

    private static final Map<Integer, Map<String, String>> titles;
    static {
        titles = new HashMap<>();

        Map<String, String> transport = new HashMap<>();
        transport.put("en", "transport");
        transport.put("ua", "Транспорт");
        transport.put("ru", "Транспорт");
        titles.put(TRANSPORT_ID, transport);

    }
    private final static List<? extends CategoryModel> categories;
    static {
        categories = Arrays.asList(
                new CategoryModelImpl(TRANSPORT_ID, titles.get(TRANSPORT_ID), "stub_category_img.png"));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categories;
    }
}
