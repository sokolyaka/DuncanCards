package sokolov.dunkancards.common.util.view;

import android.view.View;

public class HideSystemNavigation {

    private final int hideBottomSystemUiFlag =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    private final View decorView;

    public HideSystemNavigation(View decorView) {this.decorView = decorView;}

    public void hide() {
        decorView.setSystemUiVisibility(hideBottomSystemUiFlag);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {

            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(hideBottomSystemUiFlag);
                }
            }
        });
    }

}
