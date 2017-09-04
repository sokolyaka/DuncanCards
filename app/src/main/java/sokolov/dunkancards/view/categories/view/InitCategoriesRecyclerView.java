package sokolov.dunkancards.view.categories.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

class InitCategoriesRecyclerView {

    private final RecyclerView recyclerView;
    private final Context context;
    private final CategoriesAdapter.OnItemClickListener listener;

    public InitCategoriesRecyclerView(RecyclerView recyclerView, Context context, CategoriesAdapter.OnItemClickListener listener) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.listener = listener;
    }

    public CategoriesAdapter execute() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        CategoriesAdapter adapter =
                new CategoriesAdapter(
                        context.getAssets(),
                        new LinkedList<CategoryDisplayModel>(),
                        listener);

        recyclerView.setAdapter(adapter);
        return adapter;
    }
}
