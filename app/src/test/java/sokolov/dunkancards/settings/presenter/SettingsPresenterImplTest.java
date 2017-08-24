package sokolov.dunkancards.settings.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import sokolov.dunkancards.domain.repository.language.LanguageRepository;
import sokolov.dunkancards.domain.repository.settings.InMemorySettingsRepository;
import sokolov.dunkancards.settings.view.SettingsView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SettingsPresenterImplTest {

    private SettingsPresenter settingsPresenter;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private InMemorySettingsRepository settingsRepository;

    @Mock
    private SettingsView settingsView;
    @Mock
    private LanguageRepository languageRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        settingsPresenter = new SettingsPresenterImpl(settingsRepository, languageRepository, settingsView);
    }

    @Test
    public void testCaptionChecked() {
        settingsPresenter.captionChecked(true);
        verify(settingsRepository, times(1)).saveCaptionState(true);
    }

    @Test
    public void testOnResume() {
        settingsPresenter.captionChecked(true);
        settingsPresenter.selectLanguage("en");

        settingsPresenter.onResume();
        verify(settingsRepository, times(1)).getCaptionState();
        verify(settingsView, times(1)).updateCaptionState(true);
        verify(settingsRepository, times(1)).getLanguage();
        verify(settingsView, times(1)).updateLanguage("en");
    }

    @Test
    public void testLanguageSelected() throws Exception {
        settingsPresenter.selectLanguage("en");
        verify(settingsRepository, times(1)).saveLanguage("en");
    }

    @Test
    public void onCreate() throws Exception {
        settingsPresenter.onCreate();
        verify(languageRepository).getAll();
        verify(settingsView).initLanguages(Collections.EMPTY_LIST);
    }


}