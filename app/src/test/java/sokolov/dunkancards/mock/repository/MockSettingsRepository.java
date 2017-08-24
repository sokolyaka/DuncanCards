package sokolov.dunkancards.mock.repository;

import sokolov.dunkancards.settings.model.SettingsRepository;


public class MockSettingsRepository implements SettingsRepository {

    private String lang;

    public MockSettingsRepository(String lang) {this.lang = lang;}

    @Override
    public void saveCaptionState(boolean isChecked) {

    }

    @Override
    public boolean getCaptionState() {
        return false;
    }

    @Override
    public void saveLanguage(String lang) {

    }

    @Override
    public String getLanguage() {
        return lang;
    }
}
