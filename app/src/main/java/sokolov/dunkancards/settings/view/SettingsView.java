package sokolov.dunkancards.settings.view;

import java.util.List;

import sokolov.dunkancards.domain.LanguageModelImpl;

public interface SettingsView {
    void updateCaptionState(boolean isChecked);

    void updateLanguage(String lang);

    void initLanguages(List<LanguageModelImpl> languageModels);
}
