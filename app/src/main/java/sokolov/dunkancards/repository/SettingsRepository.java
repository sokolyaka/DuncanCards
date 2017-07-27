package sokolov.dunkancards.repository;

public interface SettingsRepository {
    void saveCaptionState(boolean isChecked);

    boolean getCaptionState();
}
