package sokolov.dunkancards.domain.repository.settings;

public interface SettingsRepository {
    void saveCaptionState(boolean isChecked);

    boolean getCaptionState();

    void saveLanguage(String lang);

    String getLanguage();

    int getAutoScrollPeriodInSeconds();
}
