package sokolov.dunkancards.settings;

import android.widget.CompoundButton;

import sokolov.dunkancards.settings.presenter.SettingsPresenter;

public class CaptionOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

    private final SettingsPresenter settingsPresenter;

    public CaptionOnCheckedChangeListener(SettingsPresenter settingsPresenter) {
        this.settingsPresenter = settingsPresenter;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        settingsPresenter.captionChecked(isChecked);
    }
}
