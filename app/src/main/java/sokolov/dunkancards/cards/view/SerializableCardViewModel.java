package sokolov.dunkancards.cards.view;

import java.io.Serializable;

public class SerializableCardViewModel implements CardViewModel, Serializable {

    private final String title;
    private final String imgPath;

    public SerializableCardViewModel(CardViewModel viewModel) {
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
