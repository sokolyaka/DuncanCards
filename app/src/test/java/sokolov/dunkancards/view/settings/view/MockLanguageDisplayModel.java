package sokolov.dunkancards.view.settings.view;

public class MockLanguageDisplayModel implements LanguageDisplayModel {
    private final String shortName;

    public MockLanguageDisplayModel(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String fullName() {
        return null;
    }

    @Override
    public String shortName() {
        return shortName;
    }

    @Override
    public String flagPath() {
        return null;
    }
}
