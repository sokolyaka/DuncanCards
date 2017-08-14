package sokolov.dunkancards.settings.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.settings.model.InMemorySettingsRepository;
import sokolov.dunkancards.settings.view.SettingsView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SettingsPresenterImplTest {

    private SettingsPresenter settingsPresenter;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private InMemorySettingsRepository settingsRepository;

    @Mock
    private SettingsView settingsView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        settingsPresenter = new SettingsPresenterImpl(settingsRepository, settingsView);
    }

    @Test
    public void testCaptionChecked() {
        settingsPresenter.captionChecked(true);
        verify(settingsRepository, times(1)).saveCaptionState(true);
    }

    @Test
    public void testOnResume() {
        settingsPresenter.captionChecked(true);
        settingsPresenter.onResume();
        verify(settingsRepository, times(1)).getCaptionState();
        verify(settingsView, times(1)).updateCaptionState(true);
    }

}