package sokolov.dunkancards.domain.repository.settings;

public interface SettingsRepository {

    void saveCurrentLanguage(String shortName);

    String getCurrentLanguage();

    int getAutoScrollPeriodInSeconds();

    void saveAutoScroll(int periodInSeconds);
}
