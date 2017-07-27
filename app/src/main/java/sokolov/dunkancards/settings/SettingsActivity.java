package sokolov.dunkancards.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.settings.presenter.SettingsPresenter;
import sokolov.dunkancards.settings.presenter.SettingsPresenterImpl;
import sokolov.dunkancards.settings.view.SettingsView;

public class SettingsActivity extends AppCompatActivity implements SettingsView {

    private SettingsPresenter settingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        settingsPresenter = new SettingsPresenterImpl(
               ((DuncanCardsApp) getApplication())
                       .getSettingsRepository(), this);

        ((CheckBox) findViewById(R.id.caption_check_box))
                .setOnCheckedChangeListener(
                        new CaptionOnCheckedChangeListener(settingsPresenter));

    }

    @Override
    protected void onResume() {
        super.onResume();
        settingsPresenter.onResume();
    }

    @Override
    public void updateCaptionState(boolean isChecked) {
        ((CheckBox) findViewById(R.id.caption_check_box))
                .setChecked(isChecked);
    }
}
