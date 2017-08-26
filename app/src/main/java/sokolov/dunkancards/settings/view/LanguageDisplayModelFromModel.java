package sokolov.dunkancards.settings.view;

import sokolov.dunkancards.domain.entity.language.Language;

public class LanguageDisplayModelFromModel implements LanguageDisplayModel {
    private final Language model;
    private final String flagPath;

    public LanguageDisplayModelFromModel(Language model, String flagPath) {
        this.model = model;
        this.flagPath = flagPath;
    }

    @Override
    public String fullName() {
        return model.fullName();
    }

    @Override
    public String shortName() {
        return model.shortName();
    }

    @Override
    public String flagPath() {
        return flagPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageDisplayModelFromModel that = (LanguageDisplayModelFromModel) o;

        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return flagPath != null ? flagPath.equals(that.flagPath) : that.flagPath == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (flagPath != null ? flagPath.hashCode() : 0);
        return result;
    }
}
