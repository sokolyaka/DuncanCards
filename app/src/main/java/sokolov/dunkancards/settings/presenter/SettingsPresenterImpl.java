package sokolov.dunkancards.settings.presenter;

import sokolov.dunkancards.domain.repository.language.LanguageRepository;
import sokolov.dunkancards.domain.repository.settings.SettingsRepository;
import sokolov.dunkancards.settings.view.SettingsView;

public class SettingsPresenterImpl implements SettingsPresenter {

    private final SettingsRepository settingsRepository;
    private final LanguageRepository languageRepository;
    private final SettingsView settingsView;

    public SettingsPresenterImpl(SettingsRepository settingsRepository, LanguageRepository languageRepository, SettingsView settingsView) {
        this.settingsRepository = settingsRepository;
        this.languageRepository = languageRepository;
        this.settingsView = settingsView;
    }

    @Override
    public void onCreate() {
        settingsView.initLanguages(
                languageRepository.getAll());

    }

    @Override
    public void onResume() {
        settingsView.updateLanguage(
                settingsRepository.getLanguage());

        int autoScrollPeriodInSeconds = settingsRepository.getAutoScrollPeriodInSeconds();
        if (autoScrollPeriodInSeconds < 1) {
            settingsView.turnOffAutoScroll();
        } else {
            settingsView.updateAutoScroll(autoScrollPeriodInSeconds);
        }
    }

    @Override
    public void selectLanguage(String lang) {
        settingsRepository.saveLanguage(lang);
    }

    @Override
    public void onAutoScrollSelected(int periodInSeconds) {
        settingsRepository.saveAutoScroll(periodInSeconds);
    }
}
