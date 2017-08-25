package sokolov.dunkancards.settings.presenter;

import sokolov.dunkancards.settings.view.LanguageDisplayModel;

public interface SettingsPresenter {
    void onCreate();

    void onResume();

    void selectLanguage(LanguageDisplayModel lang);

    void onAutoScrollSelected(int periodInSeconds);
}
