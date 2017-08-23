package sokolov.dunkancards.cards.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.cards.interactor.CardsInteractorImpl;
import sokolov.dunkancards.cards.model.InMemoryCardsRepository;
import sokolov.dunkancards.cards.presenter.CardsPresenter;
import sokolov.dunkancards.cards.presenter.CardsPresenterImpl;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.util.ZoomOutPageTransformer;

import static sokolov.dunkancards.categories.view.CategoriesActivity.CATEGORY_DISPLAY_MODEL;

public class CardsActivity extends AppCompatActivity implements CardsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cards);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CardsPresenter cardsPresenter =
                new CardsPresenterImpl(
                        this,
                        new CardsInteractorImpl(
                                new InMemoryCardsRepository(),
                                ((DuncanCardsApp) getApplication())
                                        .getSettingsRepository()));

        cardsPresenter.onCreate(
                (CategoryDisplayModel) getIntent()
                        .getSerializableExtra(
                                CATEGORY_DISPLAY_MODEL));
    }

    @Override
    public void showCards(List<CardDisplayModel> cards) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager
                .setAdapter(
                        new CardsPagerAdapter(
                                getSupportFragmentManager(),
                                cards));

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
}
