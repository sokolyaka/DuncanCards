package sokolov.dunkancards.view.categories.view;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import com.mingle.entity.MenuEntity;

import java.io.IOException;

import sokolov.dunkancards.R;
import sokolov.dunkancards.view.settings.view.LanguageDisplayModel;

public class LanguageMenuEntityDisplayModelBridge extends MenuEntity {
    private final LanguageDisplayModel displayModel;
    private final AssetManager assetManager;

    public LanguageMenuEntityDisplayModelBridge(LanguageDisplayModel displayModel, AssetManager assetManager) {
        this.displayModel = displayModel;
        this.assetManager = assetManager;
    }

    public LanguageMenuEntityDisplayModelBridge fill() {
        title = displayModel.fullName();
        try {
            icon =
                    Drawable.createFromStream(
                            assetManager.open(
                                    displayModel.flagPath()),
                            null);
        } catch (IOException e) {
            iconId = R.drawable.broken_card_img;
        }
        return this;
    }

    public LanguageDisplayModel getDisplayModel() {
        return displayModel;
    }
}
