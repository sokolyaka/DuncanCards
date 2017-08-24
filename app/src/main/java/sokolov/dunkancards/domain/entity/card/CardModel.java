package sokolov.dunkancards.domain.entity.card;

import java.util.Map;

public interface CardModel {
    int id();

    int categoryId();

    String imgPath();

    Map<String, String> title();
}
