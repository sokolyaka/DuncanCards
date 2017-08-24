package sokolov.dunkancards.settings.presenter;

import java.util.Arrays;

import sokolov.dunkancards.domain.LanguageModelImpl;
import sokolov.dunkancards.settings.model.SettingsRepository;
import sokolov.dunkancards.settings.view.SettingsView;

public class SettingsPresenterImpl implements SettingsPresenter {

    private final SettingsRepository settingsRepository;
    private final SettingsView settingsView;

    public SettingsPresenterImpl(SettingsRepository settingsRepository, SettingsView settingsView) {
        this.settingsRepository = settingsRepository;
        this.settingsView = settingsView;
    }

    @Override
    public void captionChecked(boolean isChecked) {
        settingsRepository.saveCaptionState(isChecked);
    }

    @Override
    public void onCreate() {
        settingsView.initLanguages(
                Arrays.asList(
                        new LanguageModelImpl("English", "en"),
                        new LanguageModelImpl("Русский", "ru"),
                        new LanguageModelImpl("Українська", "ua")));
    }

    @Override
    public void onResume() {
        settingsView.updateCaptionState(
                settingsRepository.getCaptionState());
        settingsView.updateLanguage(
                settingsRepository.getLanguage());
    }

    @Override
    public void selectLanguage(String lang) {
        settingsRepository.saveLanguage(lang);
    }
}
