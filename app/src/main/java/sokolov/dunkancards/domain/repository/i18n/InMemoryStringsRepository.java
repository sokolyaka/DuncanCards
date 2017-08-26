package sokolov.dunkancards.domain.repository.i18n;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStringsRepository implements StringsRepository {

    private final static Map<String, String> CATEGORIES_TITLE;

    static {
        CATEGORIES_TITLE = new HashMap<>();
        CATEGORIES_TITLE.put("en", "Doman's cards");
        CATEGORIES_TITLE.put("ua", "Картки Домана");
        CATEGORIES_TITLE.put("ru", "Карточки Домна");
    }

    @Override
    public String getCategoriesTitle(String currentLanguage) {
        return CATEGORIES_TITLE.get(currentLanguage);
    }
}
