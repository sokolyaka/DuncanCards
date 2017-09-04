package sokolov.dunkancards.view.settings.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.data.repository.language.InMemoryLanguageRep;
import sokolov.dunkancards.view.settings.presenter.SettingsPresenter;
import sokolov.dunkancards.view.settings.presenter.SettingsPresenterImpl;
import sokolov.dunkancards.data.repository.i18n.InMemoryFlagRepository;

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
                        this,
                        new InMemoryFlagRepository());
    }

    @Override
    protected void onResume() {
        super.onResume();
        settingsPresenter.onResume();
    }

    @Override
    public void updateLanguage(LanguageDisplayModel lang) {
        //// TODO: 23.08.2017
    }

    @Override
    public void initLanguages(List<LanguageDisplayModel> languageModels) {
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
