package sokolov.dunkancards.settings.presenter;

public interface SettingsPresenter {
    void onCreate();

    void onResume();

    void selectLanguage(String lang);

    void onAutoScrollSelected(int periodInSeconds);
}
