package sokolov.dunkancards.cards.view;

import sokolov.dunkancards.domain.entity.card.Card;

public class CardDisplayFormModel implements CardDisplayModel {
    private final Card model;
    private final String lang;

    public CardDisplayFormModel(Card model, String lang) {
        this.model = model;
        this.lang = lang;
    }

    @Override
    public String title() {
        return model.title().get(lang).toUpperCase();
    }

    @Override
    public String imgPath() {
        return model.imgPath();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardDisplayFormModel that = (CardDisplayFormModel) o;

        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return lang != null ? lang.equals(that.lang) : that.lang == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        return result;
    }
}
