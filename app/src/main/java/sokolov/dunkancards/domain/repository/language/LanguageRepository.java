package sokolov.dunkancards.domain.repository.language;

import java.util.List;

import sokolov.dunkancards.domain.entity.language.LanguageModel;

public interface LanguageRepository {
    List<LanguageModel> getAll();
}
