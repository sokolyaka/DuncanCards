package sokolov.dunkancards.domain.repository.language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sokolov.dunkancards.domain.entity.language.LanguageModel;
import sokolov.dunkancards.domain.entity.language.LanguageModelImpl;

import static java.util.Arrays.asList;

public class InMemoryLanguageRep implements LanguageRepository {
    private static final List<LanguageModel> LANGUAGE_MODELS =
            ((List) asList(
                    new LanguageModelImpl("English", "en"),
                    new LanguageModelImpl("Русский", "ru"),
                    new LanguageModelImpl("Українська", "ua")));

    @Override
    public List<LanguageModel> getAll() {
        List<LanguageModel> copy = new ArrayList<>();
        Collections.copy(copy, LANGUAGE_MODELS);
        return copy;
    }

}
