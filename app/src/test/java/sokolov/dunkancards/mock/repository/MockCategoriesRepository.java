package sokolov.dunkancards.mock.repository;

import java.util.Collections;
import java.util.List;

import sokolov.dunkancards.domain.repository.category.CategoriesRepository;
import sokolov.dunkancards.domain.entity.category.CategoryModel;

import static sokolov.dunkancards.categories.CategoriesTestData.TRANSPORT_CATEGORY;


public class MockCategoriesRepository implements CategoriesRepository {

    @Override
    public List<CategoryModel> getAllCategories() {
        return (List) Collections.singletonList(TRANSPORT_CATEGORY);
    }

}
