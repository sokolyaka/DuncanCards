package sokolov.dunkancards.settings.presenter;

public interface SettingsPresenter {
    void onCreate();

    void onResume();

    void captionChecked(boolean isChecked);

    void selectLanguage(String lang);
}
