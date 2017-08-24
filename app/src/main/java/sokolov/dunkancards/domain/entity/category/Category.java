package sokolov.dunkancards.domain.entity.category;

import java.util.Map;

public interface Category {

    int id();
    Map<String, String> title();
    String previewPath();
}
