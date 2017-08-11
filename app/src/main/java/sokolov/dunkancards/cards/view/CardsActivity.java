package sokolov.dunkancards.cards.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import sokolov.dunkancards.R;
import sokolov.dunkancards.util.HideSystemNavigation;

public class CardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        new HideSystemNavigation(getWindow().getDecorView()).hide();

        ((ViewPager) findViewById(R.id.container))
                .setAdapter(
                        new SectionsPagerAdapter(
                                getSupportFragmentManager()));
    }
}
