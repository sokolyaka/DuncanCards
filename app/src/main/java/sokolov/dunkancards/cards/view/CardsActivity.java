package sokolov.dunkancards.cards.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.cards.interactor.CardsInteractorImpl;
import sokolov.dunkancards.cards.presenter.CardsPresenter;
import sokolov.dunkancards.cards.presenter.CardsPresenterImpl;
import sokolov.dunkancards.cards.model.CardsInMemoryRepository;
import sokolov.dunkancards.util.HideSystemNavigation;
import sokolov.dunkancards.util.ZoomOutPageTransformer;

public class CardsActivity extends AppCompatActivity implements CardsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        new HideSystemNavigation(
                getWindow()
                        .getDecorView())
                .hide();

        CardsPresenter cardsPresenter =
                new CardsPresenterImpl(
                        this,
                        new CardsInteractorImpl(
                                new CardsInMemoryRepository(),
                                ((DuncanCardsApp) getApplication())
                                        .getCategoriesRepository()));
        cardsPresenter.onCreate();
    }

    @Override
    public void showCards(List<CardViewModel> cards) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager
                .setAdapter(
                        new CardsPagerAdapter(
                                getSupportFragmentManager(),
                                cards));

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
}
