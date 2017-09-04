package sokolov.dunkancards.view.categories.presenter.command;

public interface GetTitleCommand {

    void execute(Callback callback);

    interface Callback {

        void onSuccess(String title);

        void onError(Exception e);
    }

}
