package sokolov.dunkancards.domain.boundary.language;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;

public interface LanguageRepository {
    List<Language> getAll();

    Language getByShortName(String shortName);
}
