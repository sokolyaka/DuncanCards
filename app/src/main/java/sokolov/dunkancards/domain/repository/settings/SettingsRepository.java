package sokolov.dunkancards.domain.repository.settings;

public interface SettingsRepository {

    void saveLanguage(String lang);

    String getLanguage();

    int getAutoScrollPeriodInSeconds();

    void saveAutoScroll(int periodInSeconds);
}
