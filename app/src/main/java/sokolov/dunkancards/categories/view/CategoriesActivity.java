package sokolov.dunkancards.categories.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.SweetSheet;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.DuncanCardsApp;
import sokolov.dunkancards.R;
import sokolov.dunkancards.cards.view.CardsActivity;
import sokolov.dunkancards.categories.interactor.CategoriesInteractorImpl;
import sokolov.dunkancards.categories.presenter.CategoriesPresenter;
import sokolov.dunkancards.categories.presenter.CategoriesPresenterImpl;
import sokolov.dunkancards.domain.repository.i18n.InMemoryStringsRepository;
import sokolov.dunkancards.domain.repository.card.InMemoryCardsRepository;
import sokolov.dunkancards.domain.repository.category.InMemoryCategoriesRepository;
import sokolov.dunkancards.domain.repository.language.InMemoryLanguageRep;
import sokolov.dunkancards.settings.presenter.SettingsPresenter;
import sokolov.dunkancards.settings.presenter.SettingsPresenterImpl;
import sokolov.dunkancards.settings.repository.InMemoryFlagRepository;
import sokolov.dunkancards.settings.view.LanguageDisplayModel;
import sokolov.dunkancards.settings.view.SettingsView;

public class CategoriesActivity extends AppCompatActivity implements CategoriesView, SettingsView {

    public static final String CATEGORY_DISPLAY_MODEL = "CATEGORY_DISPLAY_MODEL";

    private CategoriesPresenter categoriesPresenter;
    private CategoriesAdapter mAdapter;
    private SweetSheet sweetSheet;
    private SettingsPresenter settingsPresenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.app_bar_categories);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        categoriesPresenter =
                new CategoriesPresenterImpl(
                        this,
                        new CategoriesInteractorImpl(
                                new InMemoryCategoriesRepository(),
                                new InMemoryCardsRepository(),
                                ((DuncanCardsApp) getApplication()).getSettingsRepository(),
                                new InMemoryStringsRepository()));

        mAdapter =
                new InitCategoriesRecyclerView(
                        (RecyclerView) findViewById(R.id.categories_recycler_view),
                        this,
                        new CategoriesAdapter.OnItemClickListener() {

                            @Override
                            public void onItemClick(CategoryDisplayModel item) {
                                categoriesPresenter.onCategorySelected(item);
                            }
                        })
                        .execute();

        settingsPresenter =
                new SettingsPresenterImpl(
                        ((DuncanCardsApp) getApplication()).getSettingsRepository(),
                        new InMemoryLanguageRep(),
                        this,
                        new InMemoryFlagRepository());

        settingsPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        categoriesPresenter.onViewShow();
        settingsPresenter.onResume();
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
    public void updateTitle(String title) {
        toolbar.setTitle(title);
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
                if (sweetSheet != null && !sweetSheet.isShow()) {
                    sweetSheet.show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateLanguage(LanguageDisplayModel lang) {
        // TODO: 26.08.2017
    }

    @Override
    public void initLanguages(List<LanguageDisplayModel> languageModels) {
        List<MenuEntity> entities = new ArrayList<>();
        for (LanguageDisplayModel model : languageModels) {
            entities.add(
                    new LanguageMenuEntityDisplayModelBridge(model, getAssets())
                            .fill());
        }

        sweetSheet =
                new SettingsSweetSheetInit(
                        (RelativeLayout) findViewById(R.id.content_categories),
                        new SweetSheet.OnMenuItemClickListener() {
                            @Override
                            public boolean onItemClick(int position, MenuEntity menuEntity) {
                                settingsPresenter
                                        .selectLanguage(
                                                ((LanguageMenuEntityDisplayModelBridge) menuEntity)
                                                        .getDisplayModel());
                                categoriesPresenter.onViewShow();
                                return true;
                            }
                        },
                        entities)
                        .execute();

    }

    @Override
    public void turnOffAutoScroll() {
        //// TODO: 26.08.2017
    }

    @Override
    public void updateAutoScroll(int periodInSeconds) {
        //// TODO: 26.08.2017
    }

    @Override
    public void onBackPressed() {
        if (sweetSheet != null && sweetSheet.isShow()) {
            sweetSheet.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
