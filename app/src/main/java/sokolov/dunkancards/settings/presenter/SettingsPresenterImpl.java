package sokolov.dunkancards.settings.presenter;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;
import sokolov.dunkancards.domain.repository.language.LanguageRepository;
import sokolov.dunkancards.domain.repository.settings.SettingsRepository;
import sokolov.dunkancards.settings.repository.FlagRepository;
import sokolov.dunkancards.settings.view.LanguageDisplayModel;
import sokolov.dunkancards.settings.view.LanguageDisplayModelFromModel;
import sokolov.dunkancards.settings.view.SettingsView;

public class SettingsPresenterImpl implements SettingsPresenter {

    private final SettingsRepository settingsRepository;
    private final LanguageRepository languageRepository;
    private final SettingsView settingsView;
    private final FlagRepository flagRepository;

    public SettingsPresenterImpl(SettingsRepository settingsRepository, LanguageRepository languageRepository, SettingsView settingsView, FlagRepository flagRepository) {
        this.settingsRepository = settingsRepository;
        this.languageRepository = languageRepository;
        this.settingsView = settingsView;
        this.flagRepository = flagRepository;
    }

    @Override
    public void onCreate() {
        List<Language> languages = languageRepository.getAll();
        List<LanguageDisplayModel> languageDisplayModels = new ArrayList<>();
        for (Language language : languages) {
            languageDisplayModels.add(
                    new LanguageDisplayModelFromModel(
                            language,
                            flagRepository.getPathByShortName(
                                    language.shortName())));
        }

        settingsView.initLanguages(languageDisplayModels);
    }

    @Override
    public void onResume() {
        onResumeLanguage();
        onResumeAutoScroll();
    }

    private void onResumeLanguage() {
        String currentLanguageShortName = settingsRepository.getCurrentLanguage();
        settingsView.updateLanguage(
                new LanguageDisplayModelFromModel(
                        languageRepository.getByShortName(
                                currentLanguageShortName),
                        flagRepository.getPathByShortName(
                                currentLanguageShortName)));
    }

    private void onResumeAutoScroll() {
        int autoScrollPeriodInSeconds = settingsRepository.getAutoScrollPeriodInSeconds();
        if (autoScrollPeriodInSeconds < 1) {
            settingsView.turnOffAutoScroll();
        } else {
            settingsView.updateAutoScroll(autoScrollPeriodInSeconds);
        }
    }

    @Override
    public void selectLanguage(LanguageDisplayModel lang) {
        settingsRepository.saveCurrentLanguage(lang.shortName());
    }

    @Override
    public void onAutoScrollSelected(int periodInSeconds) {
        settingsRepository.saveAutoScroll(periodInSeconds);
    }
}
