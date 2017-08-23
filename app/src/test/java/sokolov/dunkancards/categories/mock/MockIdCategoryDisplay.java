package sokolov.dunkancards.categories.mock;

import sokolov.dunkancards.categories.view.CategoryDisplayModel;


public class MockIdCategoryDisplay implements CategoryDisplayModel{

    private final int id;

    public MockIdCategoryDisplay(int id) {this.id = id;}

    @Override
    public int id() {
        return id;
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public String previewPath() {
        return null;
    }

    @Override
    public String cardsCount() {
        return null;
    }
}
