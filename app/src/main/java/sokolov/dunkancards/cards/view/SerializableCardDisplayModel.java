package sokolov.dunkancards.cards.view;

import java.io.Serializable;

public class SerializableCardDisplayModel implements CardDisplayModel, Serializable {

    private final String title;
    private final String imgPath;

    public SerializableCardDisplayModel(CardDisplayModel viewModel) {
        title = viewModel.title();
        imgPath = viewModel.imgPath();
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String imgPath() {
        return imgPath;
    }
}
