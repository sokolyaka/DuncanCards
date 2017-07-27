package sokolov.dunkancards.settings.presenter;

import sokolov.dunkancards.repository.SettingsRepository;
import sokolov.dunkancards.settings.view.SettingsView;

public class SettingsPresenterImpl implements SettingsPresenter {

    private final SettingsRepository settingsRepository;
    private final SettingsView settingsView;

    public SettingsPresenterImpl(SettingsRepository settingsRepository, SettingsView settingsView) {
        this.settingsRepository = settingsRepository;
        this.settingsView = settingsView;
    }

    @Override
    public void captionChecked(boolean isChecked) {
        settingsRepository.saveCaptionState(isChecked);
    }

    @Override
    public void onResume() {
        settingsView.updateCaptionState(
                settingsRepository.getCaptionState());
    }
}
