package sokolov.dunkancards.settings.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFlagRepository implements FlagRepository {

    private static final Map<String, String> PATHS;

    static {
        PATHS = new HashMap<>();
        PATHS.put("en", "flags/en.png");
        PATHS.put("uk", "flags/ua.png");
        PATHS.put("ru", "flags/ru.png");
    }

    @Override
    public String getPathByShortName(String languageShortName) {
        return PATHS.get(languageShortName);
    }
}
