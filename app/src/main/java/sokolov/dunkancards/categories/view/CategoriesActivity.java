package sokolov.dunkancards.categories.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.categories.interactor.CategoriesInteractorImpl;
import sokolov.dunkancards.categories.presenter.CategoriesPresenterImpl;

public class CategoriesActivity extends AppCompatActivity implements CategoriesView {

    private CategoriesPresenterImpl presenter;
    private CategoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ((NavigationView) findViewById(R.id.nav_view))
                .setNavigationItemSelectedListener(
                        new OnNavigationItemSelectedListenerImpl(this));

        presenter =
                new CategoriesPresenterImpl(
                        this,
                        new CategoriesInteractorImpl(
                                ((DuncanCardsApp) getApplication())
                                        .getCategoriesRepository()));

        mAdapter =
                new InitCategoriesRecyclerView(
                        (RecyclerView) findViewById(R.id.categories_recycler_view),
                        this,
                        new CategoriesAdapter.OnItemClickListener() {

                            @Override
                            public void onItemClick(CategoryViewModel item) {
                                presenter.onCategorySelected(item);
                            }
                        })
                        .execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewShow();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setCategories(List<CategoryViewModel> categories) {
        mAdapter.updateData(categories);
    }

    @Override
    public void launchCategoryView() {
    }
}
