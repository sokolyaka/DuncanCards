package sokolov.dunkancards.settings.view;

import java.util.List;

public interface SettingsView {

    void updateLanguage(LanguageDisplayModel lang);

    void initLanguages(List<LanguageDisplayModel> languageModels);

    void turnOffAutoScroll();

    void updateAutoScroll(int periodInSeconds);
}
