package sokolov.dunkancards.mock.data;

import java.util.ArrayList;
import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;
import sokolov.dunkancards.domain.entity.language.LanguageModel;
import sokolov.dunkancards.settings.view.LanguageDisplayModel;
import sokolov.dunkancards.settings.view.LanguageDisplayModelFromModel;

import static java.util.Arrays.asList;

public class LanguageTestData {

    public static final List<Language> LANGUAGE_MODELS =
            ((List) asList(
                    new LanguageModel("English", "en"),
                    new LanguageModel("Русский", "ru"),
                    new LanguageModel("Українська", "ua")));

    public static final List<LanguageDisplayModel> LANGUAGE_DISPLAY_MODELS;
    static {
        LANGUAGE_DISPLAY_MODELS = new ArrayList<>();
        for (Language model : LANGUAGE_MODELS) {
            LANGUAGE_DISPLAY_MODELS.add(new LanguageDisplayModelFromModel(model, null));
        }
    }
}
