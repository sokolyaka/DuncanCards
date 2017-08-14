package sokolov.dunkancards.settings.model;

public interface SettingsRepository {
    void saveCaptionState(boolean isChecked);

    boolean getCaptionState();
}
