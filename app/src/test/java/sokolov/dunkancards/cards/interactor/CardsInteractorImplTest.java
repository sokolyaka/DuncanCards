package sokolov.dunkancards.cards.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sokolov.dunkancards.repository.CardsRepository;
import sokolov.dunkancards.categories.model.CategoriesRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CardsInteractorImplTest {

    private CardsInteractorImpl cardsInteractor;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CardsRepository cardsRepository;
    @Mock(answer = Answers.RETURNS_MOCKS)
    private CategoriesRepository categoryRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardsInteractor = new CardsInteractorImpl(cardsRepository, categoryRepository);
    }

    @Test
    public void testLoadCards() {
        cardsInteractor.loadCards();
        verify(categoryRepository, times(1)).getLastSelectedCategoryId();
        verify(cardsRepository, times(1))
                .getCardsByCategoryId(
                        categoryRepository.getLastSelectedCategoryId());
    }

}