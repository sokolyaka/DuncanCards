package sokolov.dunkancards.mock.repository;

import sokolov.dunkancards.domain.repository.settings.SettingsRepository;


public class MockSettingsRepository implements SettingsRepository {

    private String lang;

    public MockSettingsRepository(String lang) {this.lang = lang;}

    @Override
    public void saveCurrentLanguage(String shortName) {

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
