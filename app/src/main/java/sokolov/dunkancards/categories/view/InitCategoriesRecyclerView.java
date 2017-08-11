package sokolov.dunkancards.categories.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

class InitCategoriesRecyclerView {

    private final RecyclerView recyclerView;
    private final Context context;

    public InitCategoriesRecyclerView(RecyclerView recyclerView, Context context) {this.recyclerView = recyclerView;
        this.context = context;
    }

    public CategoriesAdapter execute() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        CategoriesAdapter adapter = new CategoriesAdapter(context.getAssets(), new LinkedList<CategoryViewModel>());
        recyclerView.setAdapter(adapter);
        return adapter;
    }
}
