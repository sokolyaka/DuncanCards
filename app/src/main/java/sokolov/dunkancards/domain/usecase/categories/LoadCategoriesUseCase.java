package sokolov.dunkancards.domain.usecase.categories;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.Category;

public interface LoadCategoriesUseCase {

    void execute(Callback callback);

    interface Callback {

        void onSuccess(List<Category> categories);

        void onError(Exception e);
    }
}
