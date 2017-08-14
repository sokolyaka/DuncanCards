package sokolov.dunkancards.repository;

public interface CardModel {
    int id();

    int categoryId();

    String imgPath();

    String title();
}
