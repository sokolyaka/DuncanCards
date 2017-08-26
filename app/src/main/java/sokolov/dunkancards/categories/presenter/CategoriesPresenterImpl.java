package sokolov.dunkancards.categories.presenter;

import sokolov.dunkancards.categories.interactor.CategoriesInteractor;
import sokolov.dunkancards.categories.view.CategoriesView;
import sokolov.dunkancards.categories.view.CategoryDisplayModel;

public class CategoriesPresenterImpl implements CategoriesPresenter {

    private final CategoriesView categoriesView;
    private final CategoriesInteractor categoriesInteractor;

    public CategoriesPresenterImpl(CategoriesView categoriesView, CategoriesInteractor categoriesInteractor) {
        this.categoriesView = categoriesView;
        this.categoriesInteractor = categoriesInteractor;
    }

    @Override
    public void onViewShow() {
        categoriesView.setCategories(
                categoriesInteractor.loadCategories());
        categoriesView.updateTitle("Doman's cards");

    }

    @Override
    public void onCategorySelected(CategoryDisplayModel item) {
        categoriesView.launchCategoryView(item);
    }
}
