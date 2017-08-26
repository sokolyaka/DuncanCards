package sokolov.dunkancards.domain.repository.settings;

public class InMemorySettingsRepository implements SettingsRepository {

    private String lang;
    private int autoScrollPeriodInSeconds = -1;

    @Override
    public void saveCurrentLanguage(String shortName) {
        this.lang = shortName;
    }

    @Override
    public String getCurrentLanguage() {
        return lang;
    }

    @Override
    public int getAutoScrollPeriodInSeconds() {
        return autoScrollPeriodInSeconds;
    }

    @Override
    public void saveAutoScroll(int periodInSeconds) {
        autoScrollPeriodInSeconds = periodInSeconds;
    }
}
