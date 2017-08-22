package sokolov.dunkancards.categories.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

import sokolov.dunkancards.R;
import sokolov.dunkancards.cards.model.InMemoryCardsRepository;
import sokolov.dunkancards.cards.view.CardsActivity;
import sokolov.dunkancards.categories.interactor.CategoriesInteractorImpl;
import sokolov.dunkancards.categories.model.InMemoryCategoriesRepository;
import sokolov.dunkancards.categories.presenter.CategoriesPresenterImpl;

public class CategoriesActivity extends AppCompatActivity implements CategoriesView {

    public static final String CATEGORY_DISPLAY_MODEL = "CATEGORY_DISPLAY_MODEL";

    private CategoriesPresenterImpl presenter;
    private CategoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
                                new InMemoryCategoriesRepository(),
                                new InMemoryCardsRepository()));

        mAdapter =
                new InitCategoriesRecyclerView(
                        (RecyclerView) findViewById(R.id.categories_recycler_view),
                        this,
                        new CategoriesAdapter.OnItemClickListener() {

                            @Override
                            public void onItemClick(CategoryDisplayModel item) {
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
    public void setCategories(List<CategoryDisplayModel> categories) {
        mAdapter.updateData(categories);
    }

    @Override
    public void launchCategoryView(CategoryDisplayModel item) {
        Intent intent = new Intent(this, CardsActivity.class);
        intent.putExtra(CATEGORY_DISPLAY_MODEL, new SerializableCategoryDisplayModel(item));
        startActivity(intent);
    }
}
