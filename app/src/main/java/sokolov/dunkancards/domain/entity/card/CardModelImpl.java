package sokolov.dunkancards.domain.entity.card;

import java.util.Map;

public class CardModelImpl implements CardModel {
    private final int id;
    private final int categoryId;
    private final String imgPath;
    private final Map<String, String> title;

    public CardModelImpl(int id, int categoryId, String imgPath, Map<String, String> title) {
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
    public Map<String, String> title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardModelImpl cardModel = (CardModelImpl) o;

        if (id != cardModel.id) return false;
        if (categoryId != cardModel.categoryId) return false;
        if (imgPath != null ? !imgPath.equals(cardModel.imgPath) : cardModel.imgPath != null)
            return false;
        return title != null ? title.equals(cardModel.title) : cardModel.title == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
