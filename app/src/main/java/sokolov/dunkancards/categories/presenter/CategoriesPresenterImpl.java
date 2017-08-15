package sokolov.dunkancards.categories.presenter;

import sokolov.dunkancards.categories.interactor.CategoriesInteractor;
import sokolov.dunkancards.categories.view.CategoriesView;
import sokolov.dunkancards.categories.view.CategoryViewModel;

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
    }

    @Override
    public void onCategorySelected(CategoryViewModel item) {
        categoriesInteractor.selectedCategory(item);
        categoriesView.launchCategoryView();
    }
}
