package sokolov.dunkancards.repository;

public class CategoryModelImpl implements CategoryModel {

    private final String title;
    private final String previewPath;
    private final int cardsCount;

    public CategoryModelImpl(String title, String previewPath, int cardsCount) {
        this.title = title;
        this.previewPath = previewPath;
        this.cardsCount = cardsCount;
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
