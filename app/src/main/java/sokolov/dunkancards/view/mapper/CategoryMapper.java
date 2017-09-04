package sokolov.dunkancards.view.mapper;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;

public interface CategoryMapper {

    List<CategoryDisplayModel> toDisplayModel(List<Category> categories);
}
