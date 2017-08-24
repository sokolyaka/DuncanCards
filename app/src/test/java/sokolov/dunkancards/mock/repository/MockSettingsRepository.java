package sokolov.dunkancards.mock.repository;

import sokolov.dunkancards.domain.repository.settings.SettingsRepository;


public class MockSettingsRepository implements SettingsRepository {

    private String lang;

    public MockSettingsRepository(String lang) {this.lang = lang;}

    @Override
    public void saveLanguage(String lang) {

    }

    @Override
    public String getLanguage() {
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
