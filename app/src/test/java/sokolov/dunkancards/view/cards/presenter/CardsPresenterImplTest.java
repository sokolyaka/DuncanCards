package sokolov.dunkancards.view.cards.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.domain.usecase.cards.CardsInteractor;
import sokolov.dunkancards.view.cards.view.CardsView;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

import static org.mockito.Mockito.verify;

public class CardsPresenterImplTest {

    private CardsPresenterImpl cardsPresenter;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsView cardsView;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsInteractor cardsInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoryDisplayModel categoryDisplayModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardsPresenter = new CardsPresenterImpl(cardsView, cardsInteractor);
    }

    @Test
    public void testOnCreate() {
        cardsPresenter.onCreate(categoryDisplayModel);
        verify(cardsInteractor).loadCards(categoryDisplayModel);
        verify(cardsView).showCards(cardsInteractor.loadCards(categoryDisplayModel));
    }

}