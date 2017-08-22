package sokolov.dunkancards;

import android.app.Application;

import sokolov.dunkancards.settings.model.InMemorySettingsRepository;
import sokolov.dunkancards.settings.model.SettingsRepository;

public class DuncanCardsApp extends Application {

    private SettingsRepository settingsRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        settingsRepository = new InMemorySettingsRepository();
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }
}
