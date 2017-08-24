package sokolov.dunkancards.domain.repository.settings;

public class InMemorySettingsRepository implements SettingsRepository {

    private boolean isCaptionChecked;
    private String lang;

    @Override
    public void saveCaptionState(boolean isChecked) {
        isCaptionChecked = isChecked;
    }

    @Override
    public boolean getCaptionState() {
        return isCaptionChecked;
    }

    @Override
    public void saveLanguage(String lang) {
        this.lang = lang;
    }

    @Override
    public String getLanguage() {
        return lang;
    }
}
