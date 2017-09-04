package sokolov.dunkancards.data.repository.mock;

import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;


public class MockSettingsRepository implements SettingsRepository {

    private String lang;

    public MockSettingsRepository(String lang) {this.lang = lang;}

    @Override
    public void saveCurrentLanguage(String shortName) {
        lang = shortName;
    }

    @Override
    public String getCurrentLanguage() {
        return lang;
    }

    @Override
    public int getAutoScrollPeriodInSeconds() {
        return 0;
    }

    @Override
    public void saveAutoScroll(int periodInSeconds) {

    }
}
