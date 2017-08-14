package sokolov.dunkancards.cards.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.repository.CardsRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CardsInteractorImplTest {

    private CardsInteractorImpl cardsInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsRepository cardsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardsInteractor = new CardsInteractorImpl(cardsRepository);
    }

    @Test
    public void testLoadCards() {
        cardsInteractor.loadCards();
        verify(cardsRepository, times(1)).getCardsByCategory();
    }

}