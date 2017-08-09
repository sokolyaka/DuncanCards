package sokolov.dunkancards;

import android.app.Application;

import sokolov.dunkancards.repository.InMemorySettingsRepository;
import sokolov.dunkancards.repository.SettingsRepository;

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
