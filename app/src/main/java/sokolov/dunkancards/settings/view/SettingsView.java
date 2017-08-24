package sokolov.dunkancards.settings.view;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;

public interface SettingsView {
    void updateCaptionState(boolean isChecked);

    void updateLanguage(String lang);

    void initLanguages(List<Language> languageModels);

    void turnOffAutoScroll();

    void updateAutoScroll(int periodInSeconds);
}
