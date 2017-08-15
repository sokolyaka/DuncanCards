package sokolov.dunkancards.cards.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class CardsPagerAdapter extends FragmentPagerAdapter {

    private final List<CardViewModel> cards;

    public CardsPagerAdapter(FragmentManager fm, List<CardViewModel> cards) {
        super(fm);
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int position) {
        return CardFragment.newInstance(cards.get(position));
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return cards.get(position).title();
    }
}
