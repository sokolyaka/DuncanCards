package sokolov.dunkancards.repository;

public interface CategoryModel {

    int id();
    String title();
    String previewPath();
    int cardsCount();
}
