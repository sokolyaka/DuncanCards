package sokolov.dunkancards.data.repository.mock;

import java.util.Collections;
import java.util.List;

import sokolov.dunkancards.domain.boundary.category.CategoriesRepository;
import sokolov.dunkancards.domain.entity.category.Category;

import static sokolov.dunkancards.view.categories.CategoriesTestData.TRANSPORT_CATEGORY;


public class MockCategoriesRepository implements CategoriesRepository {

    @Override
    public List<Category> getAllCategories() {
        return (List) Collections.singletonList(TRANSPORT_CATEGORY);
    }

}
