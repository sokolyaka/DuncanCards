package sokolov.dunkancards.view.categories.view;

import java.io.Serializable;

public class SerializableCategoryDisplayModel implements CategoryDisplayModel, Serializable {
    private final int id;
    private final String title;
    private final String previewPath;
    private final String cardsCount;

    public SerializableCategoryDisplayModel(CategoryDisplayModel displayModel) {
        id = displayModel.id();
        title = displayModel.title();
        previewPath = displayModel.previewPath();
        cardsCount = displayModel.cardsCount();
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String previewPath() {
        return previewPath;
    }

    @Override
    public String cardsCount() {
        return cardsCount;
    }
}
