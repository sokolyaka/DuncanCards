package sokolov.dunkancards.domain.repository.language;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Language> copy = new ArrayList<>();
        Collections.copy(copy, LANGUAGE_MODELS);
        return copy;
    }

}
