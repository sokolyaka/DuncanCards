package sokolov.dunkancards.repository;

public class CardModelImpl implements CardModel {
    private final int id;
    private final int categoryId;
    private final String imgPath;
    private final String title;

    public CardModelImpl(int id, int categoryId, String imgPath, String title) {
        this.id = id;
        this.categoryId = categoryId;
        this.imgPath = imgPath;
        this.title = title;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int categoryId() {
        return categoryId;
    }

    @Override
    public String imgPath() {
        return imgPath;
    }

    @Override
    public String title() {
        return title;
    }
}
