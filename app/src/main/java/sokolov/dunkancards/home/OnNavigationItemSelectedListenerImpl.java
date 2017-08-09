package sokolov.dunkancards.home;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import sokolov.dunkancards.R;
import sokolov.dunkancards.settings.SettingsActivity;

public class OnNavigationItemSelectedListenerImpl implements NavigationView.OnNavigationItemSelectedListener {
    private final Activity activity;

    public OnNavigationItemSelectedListenerImpl(Activity activity) {
        this.activity = activity;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (!item.isChecked()) {
            switch (item.getItemId()) {
                case R.id.nav_settings:
                    activity
                            .startActivity(
                                    new Intent(
                                            activity,
                                            SettingsActivity.class));
                case R.id.nav_donate:

                    break;
            }
        }

        ((DrawerLayout) activity
                .findViewById(R.id.drawer_layout))
                .closeDrawer(GravityCompat.START);

        return true;
    }
}
