package sokolov.dunkancards.view.categories.presenter;

import java.util.List;

import sokolov.dunkancards.domain.entity.category.Category;
import sokolov.dunkancards.domain.usecase.categories.LoadCategoriesUseCase;
import sokolov.dunkancards.view.categories.presenter.command.GetTitleCommand;
import sokolov.dunkancards.view.categories.view.CategoriesView;
import sokolov.dunkancards.view.categories.view.CategoryDisplayModel;
import sokolov.dunkancards.view.mapper.CategoryMapper;

public class CategoriesPresenterImpl implements CategoriesPresenter {

    private final CategoriesView categoriesView;
    private final LoadCategoriesUseCase loadCategoriesUseCase;
    private final CategoryMapper categoryMapper;
    private final GetTitleCommand getTitleCommand;

    public CategoriesPresenterImpl(CategoriesView categoriesView, LoadCategoriesUseCase loadCategoriesUseCase, CategoryMapper categoryMapper, GetTitleCommand getTitleCommand) {
        this.categoriesView = categoriesView;
        this.loadCategoriesUseCase = loadCategoriesUseCase;
        this.categoryMapper = categoryMapper;
        this.getTitleCommand = getTitleCommand;
    }

    @Override
    public void onViewShow() {
        loadCategoriesUseCase.execute(
                new LoadCategoriesUseCase.Callback() {

                    @Override
                    public void onSuccess(List<Category> categories) {
                        categoriesView.setCategories(
                                categoryMapper.toDisplayModel(
                                        categories));

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

        getTitleCommand.execute(new GetTitleCommand.Callback() {

            @Override
            public void onSuccess(String title) {
                categoriesView.updateTitle(title);
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }

    @Override
    public void onCategorySelected(CategoryDisplayModel item) {
        categoriesView.launchCategoryView(item);
    }
}
