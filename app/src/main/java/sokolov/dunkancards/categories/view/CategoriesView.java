package sokolov.dunkancards.categories.view;

import java.util.List;

public interface CategoriesView {

    void setCategories(List<CategoryDisplayModel> categories);

    void launchCategoryView(CategoryDisplayModel item);
}
