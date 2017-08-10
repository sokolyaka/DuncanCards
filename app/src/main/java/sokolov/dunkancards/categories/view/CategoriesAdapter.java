package sokolov.dunkancards.categories.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sokolov.dunkancards.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private final List<String> items;

    public CategoriesAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.category_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateData(List<String> viewModels) {
        items.clear();
        items.addAll(viewModels);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;

        ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
}