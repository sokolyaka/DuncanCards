package sokolov.dunkancards.view.cards.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.common.util.view.ZoomOutPageTransformer;
import sokolov.dunkancards.data.repository.card.InMemoryCardsRepository;
import sokolov.dunkancards.domain.usecase.cards.LoadCardsUseCaseImpl;
import sokolov.dunkancards.view.cards.presenter.CardsPresenterImpl;
import sokolov.dunkancards.view.mapper.CardsMapperImpl;

import static sokolov.dunkancards.view.categories.view.CategoriesActivity.SELECTED_CATEGORY_ID;

public class CardsActivity extends AppCompatActivity implements CardsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cards);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new CardsPresenterImpl(
                this,
                new LoadCardsUseCaseImpl(
                        new InMemoryCardsRepository(),
                        getIntent().getIntExtra(SELECTED_CATEGORY_ID, -1)),
                new CardsMapperImpl(
                        ((DuncanCardsApp) getApplication())
                                .getSettingsRepository()))
                .onCreate();
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
