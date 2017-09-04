package sokolov.dunkancards.view.categories.view;

import java.util.List;

public interface CategoriesView {

    void setCategories(List<CategoryDisplayModel> categories);

    void launchCategoryView(CategoryDisplayModel item);

    void updateTitle(String title);
}
