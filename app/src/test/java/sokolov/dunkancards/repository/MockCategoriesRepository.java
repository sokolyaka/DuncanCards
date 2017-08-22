package sokolov.dunkancards.repository;

import java.util.Collections;
import java.util.List;

import sokolov.dunkancards.categories.model.CategoriesRepository;
import sokolov.dunkancards.categories.model.CategoryModel;
import sokolov.dunkancards.categories.model.CategoryModelImpl;

import static sokolov.dunkancards.categories.model.CategoriesConstants.TRANSPORT_ID;


public class MockCategoriesRepository implements CategoriesRepository {

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List) Collections.singletonList(new CategoryModelImpl(TRANSPORT_ID, "Title", "previewPath"));
    }

}
