package sokolov.dunkancards.view.settings.presenter;

import sokolov.dunkancards.view.settings.view.LanguageDisplayModel;

public interface SettingsPresenter {
    void onCreate();

    void onResume();

    void selectLanguage(LanguageDisplayModel lang);

    void onAutoScrollSelected(int periodInSeconds);
}
