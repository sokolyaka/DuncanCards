package sokolov.dunkancards.domain.repository.language;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;
import sokolov.dunkancards.domain.entity.language.LanguageModel;

import static java.util.Arrays.asList;

public class InMemoryLanguageRep implements LanguageRepository {
    private static final List<Language> LANGUAGE_MODELS =
            ((List) asList(
                    new LanguageModel("English", "en"),
                    new LanguageModel("Русский", "ru"),
                    new LanguageModel("Українська", "ua")));

    @Override
    public List<Language> getAll() {
        return new ArrayList<>(LANGUAGE_MODELS);
    }

    @Override
    public Language getByShortName(String shortName) {
        for (Language model : LANGUAGE_MODELS) {
            if (model.shortName().equals(shortName)) {
                return model;
            }
        }
        return null;
    }

}
