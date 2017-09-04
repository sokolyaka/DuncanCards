package sokolov.dunkancards.domain.boundary.settings;

public interface SettingsRepository {

    void saveCurrentLanguage(String shortName);

    String getCurrentLanguage();

    int getAutoScrollPeriodInSeconds();

    void saveAutoScroll(int periodInSeconds);
}
