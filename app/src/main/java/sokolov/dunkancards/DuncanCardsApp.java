package sokolov.dunkancards;

import android.app.Application;

import sokolov.dunkancards.repository.CategoriesRepository;
import sokolov.dunkancards.repository.InMemoryCategoriesRepository;
import sokolov.dunkancards.repository.InMemorySettingsRepository;
import sokolov.dunkancards.repository.SettingsRepository;

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
