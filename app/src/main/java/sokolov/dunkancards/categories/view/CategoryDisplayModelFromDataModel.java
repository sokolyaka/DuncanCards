package sokolov.dunkancards.categories.view;

import sokolov.dunkancards.domain.entity.category.CategoryModel;

public class CategoryDisplayModelFromDataModel implements CategoryDisplayModel {

    private final CategoryModel model;
    private final int cardsCount;
    private final String lang;

    public CategoryDisplayModelFromDataModel(CategoryModel model, int cardsCount, String lang) {
        this.model = model;
        this.cardsCount = cardsCount;
        this.lang = lang;
    }

    @Override
    public int id() {
        return model.id();
    }

    @Override
    public String title() {
        return model.title().get(lang);
    }

    @Override
    public String previewPath() {
        return model.previewPath();
    }

    @Override
    public String cardsCount() {
        return
                String.valueOf(cardsCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDisplayModelFromDataModel that = (CategoryDisplayModelFromDataModel) o;

        if (cardsCount != that.cardsCount) return false;
        return model != null ? model.equals(that.model) : that.model == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + cardsCount;
        return result;
    }
}
