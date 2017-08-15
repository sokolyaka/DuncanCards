package sokolov.dunkancards;

import android.app.Application;

import sokolov.dunkancards.categories.model.CategoriesRepository;
import sokolov.dunkancards.categories.model.InMemoryCategoriesRepository;
import sokolov.dunkancards.settings.model.InMemorySettingsRepository;
import sokolov.dunkancards.settings.model.SettingsRepository;

public class DuncanCardsApp extends Application {

    private SettingsRepository settingsRepository;
    private CategoriesRepository categoryRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        settingsRepository = new InMemorySettingsRepository();
        categoryRepository = new InMemoryCategoriesRepository();
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }

    public CategoriesRepository getCategoriesRepository() {
        return categoryRepository;
    }
}
