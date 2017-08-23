package sokolov.dunkancards.categories.model;

import java.util.Map;

public interface CategoryModel {

    int id();
    Map<String, String> title();
    String previewPath();
}
