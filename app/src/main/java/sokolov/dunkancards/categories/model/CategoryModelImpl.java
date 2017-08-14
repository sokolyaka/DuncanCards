package sokolov.dunkancards.categories.model;

public class CategoryModelImpl implements CategoryModel {

    private final int id;
    private final String title;
    private final String previewPath;
    private final int cardsCount;

    public CategoryModelImpl(int id, String title, String previewPath, int cardsCount) {
        this.id = id;
        this.title = title;
        this.previewPath = previewPath;
        this.cardsCount = cardsCount;
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
    public int cardsCount() {
        return cardsCount;
    }
}
