package sokolov.dunkancards.domain.entity.language;

public class LanguageModelImpl implements LanguageModel {
    private final String fullName;
    private final String shortName;

    public LanguageModelImpl(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public String shortName() {
        return shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageModelImpl that = (LanguageModelImpl) o;

        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null)
            return false;
        return shortName != null ? shortName.equals(that.shortName) : that.shortName == null;

    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        return result;
    }
}
