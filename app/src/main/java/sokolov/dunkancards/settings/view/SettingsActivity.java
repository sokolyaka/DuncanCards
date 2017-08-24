package sokolov.dunkancards.settings.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.domain.entity.language.Language;
import sokolov.dunkancards.domain.repository.language.InMemoryLanguageRep;
import sokolov.dunkancards.settings.presenter.SettingsPresenter;
import sokolov.dunkancards.settings.presenter.SettingsPresenterImpl;

public class SettingsActivity extends AppCompatActivity implements SettingsView {

    private SettingsPresenter settingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        settingsPresenter =
                new SettingsPresenterImpl(
               ((DuncanCardsApp) getApplication())
                       .getSettingsRepository(),
                        new InMemoryLanguageRep(),
                        this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        settingsPresenter.onResume();
    }

    @Override
    public void updateLanguage(String lang) {
        //// TODO: 23.08.2017
    }

    @Override
    public void initLanguages(List<Language> languageModels) {
        //// TODO: 24.08.2017
    }

    @Override
    public void turnOffAutoScroll() {
        //// TODO: 24.08.2017
    }

    @Override
    public void updateAutoScroll(int periodInSeconds) {
        //// TODO: 24.08.2017
    }
}
