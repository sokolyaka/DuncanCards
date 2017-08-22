package sokolov.dunkancards.categories.view;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import sokolov.dunkancards.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private final AssetManager assetManager;
    private final List<CategoryDisplayModel> items;
    private final OnItemClickListener listener;

    public CategoriesAdapter(AssetManager assetManager, List<CategoryDisplayModel> items, OnItemClickListener listener) {
        this.assetManager = assetManager;
        this.items = items;
        this.listener = listener;
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
        holder.bind(items.get(position), listener, assetManager);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateData(List<CategoryDisplayModel> viewModels) {
        items.clear();
        items.addAll(viewModels);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final View container;
        private final TextView title;
        private final ImageView preview;
        private final TextView cardsCount;

        ViewHolder(CardView v) {
            super(v);
            container = itemView.findViewById(R.id.container);
            title = (TextView) itemView.findViewById(R.id.title);
            preview = (ImageView) itemView.findViewById(R.id.preview);
            cardsCount = (TextView) itemView.findViewById(R.id.cards_count);
        }

        public void bind(final CategoryDisplayModel viewModel, final OnItemClickListener listener, AssetManager assetManager) {
            title.setText(viewModel.title());

            try {
                preview.setImageDrawable(
                        Drawable.createFromStream(
                                assetManager.open(
                                        viewModel.previewPath()),
                                null));

            } catch (IOException e) {
                preview.setImageResource(R.drawable.broken_category_img);
            }

            cardsCount.setText(viewModel.cardsCount());

            container.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemClick(viewModel);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(CategoryDisplayModel item);
    }

}