package sokolov.dunkancards.mock.data;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;
import sokolov.dunkancards.domain.entity.language.LanguageModel;

import static java.util.Arrays.asList;

public class LanguageTestData {

    public static final List<Language> LANGUAGE_MODELS =
            ((List) asList(
                    new LanguageModel("English", "en"),
                    new LanguageModel("Русский", "ru"),
                    new LanguageModel("Українська", "ua")));
}
