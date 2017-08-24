package sokolov.dunkancards.categories.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.cards.model.InMemoryCardsRepository;
import sokolov.dunkancards.cards.view.CardsActivity;
import sokolov.dunkancards.categories.interactor.CategoriesInteractorImpl;
import sokolov.dunkancards.categories.model.InMemoryCategoriesRepository;
import sokolov.dunkancards.categories.presenter.CategoriesPresenterImpl;
import sokolov.dunkancards.settings.view.SettingsActivity;

public class CategoriesActivity extends AppCompatActivity implements CategoriesView {

    public static final String CATEGORY_DISPLAY_MODEL = "CATEGORY_DISPLAY_MODEL";

    private CategoriesPresenterImpl presenter;
    private CategoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.app_bar_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        presenter =
                new CategoriesPresenterImpl(
                        this,
                        new CategoriesInteractorImpl(
                                new InMemoryCategoriesRepository(),
                                new InMemoryCardsRepository(),
                                ((DuncanCardsApp) getApplication()).getSettingsRepository()));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.categories_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
