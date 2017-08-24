package sokolov.dunkancards.categories;

import java.util.HashMap;
import java.util.Map;

import sokolov.dunkancards.domain.entity.category.CategoryModel;
import sokolov.dunkancards.domain.entity.category.CategoryModelImpl;

import static sokolov.dunkancards.domain.repository.category.CategoriesConstants.TRANSPORT_ID;

public class CategoriesTestData {

    public static final CategoryModel TRANSPORT_CATEGORY;

    static {
        Map<String, String> transport = new HashMap<>();
        transport.put("en", "transport");
        transport.put("ua", "Транспорт");
        transport.put("ru", "Транспорт");
        TRANSPORT_CATEGORY =
                new CategoryModelImpl(
                        TRANSPORT_ID,
                        transport,
                        "previewPath");
    }
}
