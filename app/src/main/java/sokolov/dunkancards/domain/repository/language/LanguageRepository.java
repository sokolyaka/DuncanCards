package sokolov.dunkancards.domain.repository.language;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.Language;

public interface LanguageRepository {
    List<Language> getAll();
}
