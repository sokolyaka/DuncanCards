package sokolov.dunkancards.home.interactor;

import java.util.List;

import sokolov.dunkancards.repository.CategoriesRepository;

public class CategoriesInteractorImpl implements CategoriesInteractor {

    private final CategoriesRepository categoryRepository;

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    @Override
    public List<String> loadCategories() {
        return categoryRepository.getAllCategories();
    }
}
