package sokolov.dunkancards;

import android.app.Application;

import java.util.Locale;

import sokolov.dunkancards.data.repository.settings.InMemorySettingsRepository;
import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;

public class DuncanCardsApp extends Application {

    private SettingsRepository settingsRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        settingsRepository = new InMemorySettingsRepository();

        if (settingsRepository.getCurrentLanguage() == null) {
            settingsRepository.saveCurrentLanguage(Locale.getDefault().getLanguage());
        }
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }
}
