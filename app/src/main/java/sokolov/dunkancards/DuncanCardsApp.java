package sokolov.dunkancards;

import android.app.Application;

import java.util.Locale;

import sokolov.dunkancards.domain.repository.settings.InMemorySettingsRepository;
import sokolov.dunkancards.domain.repository.settings.SettingsRepository;

public class DuncanCardsApp extends Application {

    private SettingsRepository settingsRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        settingsRepository = new InMemorySettingsRepository();

        if (settingsRepository.getLanguage() == null) {
            settingsRepository.saveLanguage(Locale.getDefault().getLanguage());
        }
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }
}
