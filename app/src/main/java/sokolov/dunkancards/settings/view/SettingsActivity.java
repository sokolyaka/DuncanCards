package sokolov.dunkancards.settings.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.domain.LanguageModelImpl;
import sokolov.dunkancards.settings.presenter.SettingsPresenter;
import sokolov.dunkancards.settings.presenter.SettingsPresenterImpl;

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

    @Override
    public void updateLanguage(String lang) {
        //// TODO: 23.08.2017
    }

    @Override
    public void initLanguages(List<LanguageModelImpl> languageModels) {
        //// TODO: 24.08.2017
    }
}
