package sokolov.dunkancards.categories.presenter;

import sokolov.dunkancards.categories.view.CategoryDisplayModel;

interface CategoriesPresenter {

    void onViewShow();

    void onCategorySelected(CategoryDisplayModel item);
}
