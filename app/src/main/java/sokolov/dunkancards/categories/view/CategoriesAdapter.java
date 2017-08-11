package sokolov.dunkancards.categories.view;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import sokolov.dunkancards.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private final AssetManager assetManager;
    private final List<CategoryViewModel> items;

    public CategoriesAdapter(AssetManager assetManager, List<CategoryViewModel> items) {
        this.assetManager = assetManager;
        this.items = items;
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.category_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryViewModel viewModel = items.get(position);

        holder.title.setText(viewModel.title());

        try {
            holder.preview.setImageDrawable(
                    Drawable.createFromStream(
                            assetManager.open(
                                    viewModel.previewPath()),
                            null));

        } catch (IOException e) {
            holder.preview.setBackgroundResource(R.drawable.broken_category_img);
        }

        holder.cardsCount.setText(viewModel.cardsCount());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateData(List<CategoryViewModel> viewModels) {
        items.clear();
        items.addAll(viewModels);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView preview;
        private final TextView cardsCount;

        ViewHolder(CardView v) {
            super(v);
            title = (TextView) itemView.findViewById(R.id.title);
            preview = (ImageView) itemView.findViewById(R.id.preview);
            cardsCount = (TextView) itemView.findViewById(R.id.cards_count);
        }
    }
}