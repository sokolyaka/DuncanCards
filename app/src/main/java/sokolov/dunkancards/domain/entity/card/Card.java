package sokolov.dunkancards.domain.entity.card;

import java.util.Map;

public interface Card {
    int id();

    int categoryId();

    String imgPath();

    Map<String, String> title();
}
