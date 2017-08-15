package sokolov.dunkancards.cards.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.cards.interactor.CardsInteractor;
import sokolov.dunkancards.cards.view.CardsView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CardsPresenterImplTest {

    private CardsPresenterImpl cardsPresenter;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsView cardsView;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsInteractor cardsInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardsPresenter = new CardsPresenterImpl(cardsView, cardsInteractor);
    }

    @Test
    public void testOnCreate() {
        cardsPresenter.onCreate();
        verify(cardsInteractor, times(1)).loadCards();
        verify(cardsView, times(1)).showCards(cardsInteractor.loadCards());
    }

}