package sokolov.dunkancards.categories.presenter;

import sokolov.dunkancards.categories.view.CategoryViewModel;

interface CategoriesPresenter {

    void onViewShow();

    void onCategorySelected(CategoryViewModel item);
}
