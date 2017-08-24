package sokolov.dunkancards.mock.data;

import java.util.List;

import sokolov.dunkancards.domain.LanguageModel;
import sokolov.dunkancards.domain.LanguageModelImpl;

import static java.util.Arrays.asList;

public class LanguageTestData {

    public static final List<LanguageModel> LANGUAGE_MODELS =
            ((List) asList(
                    new LanguageModelImpl("English", "en"),
                    new LanguageModelImpl("Русский", "ru"),
                    new LanguageModelImpl("Українська", "ua")));
}
