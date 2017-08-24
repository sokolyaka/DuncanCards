package sokolov.dunkancards.domain.repository.language;

import java.util.List;

import sokolov.dunkancards.domain.LanguageModel;

public interface LanguageRepository {
    List<LanguageModel> getAll();
}
