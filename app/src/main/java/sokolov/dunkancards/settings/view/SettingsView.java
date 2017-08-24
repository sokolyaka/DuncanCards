package sokolov.dunkancards.settings.view;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.LanguageModel;

public interface SettingsView {
    void updateCaptionState(boolean isChecked);

    void updateLanguage(String lang);

    void initLanguages(List<LanguageModel> languageModels);
}
