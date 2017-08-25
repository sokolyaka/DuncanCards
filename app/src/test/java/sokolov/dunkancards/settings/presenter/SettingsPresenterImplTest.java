package sokolov.dunkancards.settings.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.domain.entity.language.LanguageModel;
import sokolov.dunkancards.domain.repository.language.InMemoryLanguageRep;
import sokolov.dunkancards.domain.repository.settings.InMemorySettingsRepository;
import sokolov.dunkancards.mock.data.LanguageTestData;
import sokolov.dunkancards.settings.repository.FlagRepository;
import sokolov.dunkancards.settings.view.LanguageDisplayModelFromModel;
import sokolov.dunkancards.settings.view.MockLanguageDisplayModel;
import sokolov.dunkancards.settings.view.SettingsView;

import static org.mockito.Mockito.verify;

public class SettingsPresenterImplTest {

    private SettingsPresenter settingsPresenter;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private InMemorySettingsRepository settingsRepository;

    @Mock
    private SettingsView settingsView;
    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private InMemoryLanguageRep languageRepository;
    @Mock
    private FlagRepository flagRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        settingsPresenter = new SettingsPresenterImpl(settingsRepository, languageRepository, settingsView, flagRepository);
    }

    @Test
    public void testOnResumeLanguage() {
        settingsRepository.saveCurrentLanguage("en");

        settingsPresenter.onResume();
        verify(settingsView)
                .updateLanguage(
                        new LanguageDisplayModelFromModel(
                                new LanguageModel("English", "en"), null));
    }

    @Test
    public void testOnResumeAutoScroll() throws Exception {
        settingsRepository.saveAutoScroll(0);

        settingsPresenter.onResume();
        verify(settingsView).turnOffAutoScroll();

        settingsPresenter.onAutoScrollSelected(5);
        settingsPresenter.onResume();
        verify(settingsView).updateAutoScroll(5);
    }


    @Test
    public void testLanguageSelected() throws Exception {
        settingsPresenter.selectLanguage(new MockLanguageDisplayModel("en"));
        verify(settingsRepository).saveCurrentLanguage("en");
    }

    @Test
    public void onCreate() throws Exception {
        settingsPresenter.onCreate();
        verify(languageRepository).getAll();
        verify(settingsView).initLanguages(LanguageTestData.LANGUAGE_DISPLAY_MODELS);
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