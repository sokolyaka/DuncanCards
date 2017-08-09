package sokolov.dunkancards.home.interactor;

import java.util.List;

import sokolov.dunkancards.repository.CategoriesRepository;

public class CategoriesInteractorImpl implements CategoriesInteractor{

    public CategoriesInteractorImpl(CategoriesRepository categoryRepository) {}

    @Override
    public List<String> loadCategories() {
        return null;
    }
}
