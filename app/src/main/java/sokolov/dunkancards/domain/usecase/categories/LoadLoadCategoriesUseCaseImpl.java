package sokolov.dunkancards.domain.usecase.categories;

import sokolov.dunkancards.domain.boundary.category.CategoriesRepository;

public class LoadLoadCategoriesUseCaseImpl implements LoadCategoriesUseCase {

    private final CategoriesRepository categoryRepository;

    public LoadLoadCategoriesUseCaseImpl(CategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(Callback callback) {
        try {
            callback.onSuccess(categoryRepository.getAllCategories());
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}
