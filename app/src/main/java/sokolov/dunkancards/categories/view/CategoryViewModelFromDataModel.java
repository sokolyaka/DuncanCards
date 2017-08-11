package sokolov.dunkancards.categories.view;

import sokolov.dunkancards.repository.CategoryModel;

public class CategoryViewModelFromDataModel implements CategoryViewModel {

    private final CategoryModel model;

    public CategoryViewModelFromDataModel(CategoryModel model) {this.model = model;}

    @Override
    public int id() {
        return model.id();
    }

    @Override
    public String title() {
        return model.title();
    }

    @Override
    public String previewPath() {
        return model.previewPath();
    }

    @Override
    public String cardsCount() {
        return
                String.valueOf(
                        model.cardsCount());
    }
}
