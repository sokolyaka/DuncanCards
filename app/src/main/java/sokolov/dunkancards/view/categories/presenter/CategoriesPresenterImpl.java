package sokolov.dunkancards.view.categories.presenter;

import sokolov.dunkancards.domain.usecase.categories.CategoriesInteractor;
import sokolov.dunkancards.view.categories.view.CategoriesView;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

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
        categoriesView.updateTitle(
                categoriesInteractor.getTitle());

    }

    @Override
    public void onCategorySelected(CategoryDisplayModel item) {
        categoriesView.launchCategoryView(item);
    }
}
