package sokolov.dunkancards.categories;

import java.util.HashMap;
import java.util.Map;

import sokolov.dunkancards.categories.model.CategoryModel;
import sokolov.dunkancards.categories.model.CategoryModelImpl;

import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;

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
