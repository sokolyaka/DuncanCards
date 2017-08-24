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
    public void testOnResume() {
        settingsPresenter.selectLanguage("en");

        settingsPresenter.onResume();
        verify(settingsRepository).getLanguage();
        verify(settingsView).updateLanguage("en");
        verify(settingsRepository).getAutoScrollPeriodInSeconds();
        verify(settingsView).turnOffAutoScroll();
    }

    @Test
    public void testLanguageSelected() throws Exception {
        settingsPresenter.selectLanguage("en");
        verify(settingsRepository).saveLanguage("en");
    }

    @Test
    public void onCreate() throws Exception {
        settingsPresenter.onCreate();
        verify(languageRepository).getAll();
        verify(settingsView).initLanguages(Collections.EMPTY_LIST);
    }

    @Test
    public void testSetAutoScrollTime() throws Exception {
        settingsPresenter.onAutoScrollSelected(1);
        verify(settingsRepository).saveAutoScroll(1);
    }

    @Test
    public void testSetAutoScrollTimeToView() throws Exception {
        settingsRepository.saveAutoScroll(1);
        settingsPresenter.onResume();
        verify(settingsView).updateAutoScroll(1);
    }
}