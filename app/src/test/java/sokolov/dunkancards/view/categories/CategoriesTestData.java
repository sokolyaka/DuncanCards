package sokolov.dunkancards.view.categories;

import java.util.HashMap;
import java.util.Map;

import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.domain.entity.category.CategoryModel;

import static sokolov.dunkancards.data.repository.category.CategoriesConstants.TRANSPORT_ID;

public class CategoriesTestData {

    public static final Category TRANSPORT_CATEGORY;

    static {
        Map<String, String> transport = new HashMap<>();
        transport.put("en", "transport");
        transport.put("uk", "Транспорт");
        transport.put("ru", "Транспорт");
        TRANSPORT_CATEGORY =
                new CategoryModel(
                        TRANSPORT_ID,
                        transport,
                        "previewPath");
    }
}
