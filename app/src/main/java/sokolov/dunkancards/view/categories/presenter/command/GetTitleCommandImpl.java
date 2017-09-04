package sokolov.dunkancards.view.categories.presenter.command;

import sokolov.dunkancards.domain.boundary.i18n.StringsRepository;
import sokolov.dunkancards.domain.boundary.settings.SettingsRepository;

public class GetTitleCommandImpl implements GetTitleCommand {

    private final SettingsRepository settingsRepository;
    private final StringsRepository stringsRepository;

    public GetTitleCommandImpl(SettingsRepository settingsRepository, StringsRepository stringsRepository) {
        this.settingsRepository = settingsRepository;
        this.stringsRepository = stringsRepository;
    }

    @Override
    public void execute(Callback callback) {
        try {
            callback.onSuccess(
                    stringsRepository.getCategoriesTitle(
                            settingsRepository.getCurrentLanguage()));
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
