package sokolov.dunkancards.categories.view;

import sokolov.dunkancards.categories.model.CategoryModel;

public class CategoryDisplayModelFromDataModel implements CategoryDisplayModel {

    private final CategoryModel model;

    public CategoryDisplayModelFromDataModel(CategoryModel model) {this.model = model;}

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
