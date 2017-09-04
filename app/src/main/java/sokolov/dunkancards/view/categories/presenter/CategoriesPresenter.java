package sokolov.dunkancards.view.categories.presenter;

import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

public interface CategoriesPresenter {

    void onViewShow();

    void onCategorySelected(CategoryDisplayModel item);
}
