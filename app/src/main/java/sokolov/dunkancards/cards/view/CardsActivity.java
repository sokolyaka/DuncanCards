package sokolov.dunkancards.cards.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import sokolov.dunkancards.R;
import sokolov.dunkancards.util.HideSystemNavigation;
import sokolov.dunkancards.util.ZoomOutPageTransformer;

public class CardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        new HideSystemNavigation(getWindow().getDecorView()).hide();

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager
                .setAdapter(
                        new SectionsPagerAdapter(
                                getSupportFragmentManager()));

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
}
