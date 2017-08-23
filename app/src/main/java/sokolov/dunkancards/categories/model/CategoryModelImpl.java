package sokolov.dunkancards.categories.model;

import java.util.Map;

public class CategoryModelImpl implements CategoryModel {

    private final int id;
    private final Map<String, String> title;
    private final String previewPath;

    public CategoryModelImpl(int id, Map<String, String> title, String previewPath) {
        this.id = id;
        this.title = title;
        this.previewPath = previewPath;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public Map<String, String> title() {
        return title;
    }

    @Override
    public String previewPath() {
        return previewPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryModelImpl that = (CategoryModelImpl) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return previewPath != null ? previewPath.equals(that.previewPath) : that.previewPath == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (previewPath != null ? previewPath.hashCode() : 0);
        return result;
    }
}
