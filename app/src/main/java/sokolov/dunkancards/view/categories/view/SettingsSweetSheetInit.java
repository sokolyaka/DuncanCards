package sokolov.dunkancards.view.categories.view;

import android.widget.RelativeLayout;

import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.BlurEffect;
import com.mingle.sweetpick.RecyclerViewDelegate;
import com.mingle.sweetpick.SweetSheet;

import java.util.List;

public class SettingsSweetSheetInit {
    private final RelativeLayout parentVG;
    private final SweetSheet.OnMenuItemClickListener listener;
    private final List<MenuEntity> menuEntities;

    public SettingsSweetSheetInit(RelativeLayout parentVG, SweetSheet.OnMenuItemClickListener listener, List<MenuEntity> menuEntities) {
        this.parentVG = parentVG;
        this.listener = listener;
        this.menuEntities = menuEntities;
    }

    public SweetSheet execute() {
        SweetSheet sweetSheet = new SweetSheet(parentVG);
        sweetSheet.setMenuList(menuEntities);
        sweetSheet.setDelegate(new RecyclerViewDelegate(false));
        sweetSheet.setBackgroundEffect(new BlurEffect(8));
        sweetSheet.setOnMenuItemClickListener(listener);
        return sweetSheet;
    }
}
