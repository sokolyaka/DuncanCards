package sokolov.dunkancards.settings.model;

public class InMemorySettingsRepository implements SettingsRepository {

    private boolean isCaptionChecked;

    @Override
    public void saveCaptionState(boolean isChecked) {
        isCaptionChecked = isChecked;
    }

    @Override
    public boolean getCaptionState() {
        return isCaptionChecked;
    }
}
