package sokolov.dunkancards.cards.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import sokolov.dunkancards.R;

public class CardFragment extends Fragment {

    private static final String VIEW_MODEL = "VIEW_MODEL";

    public static CardFragment newInstance(CardViewModel viewModel) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putSerializable(VIEW_MODEL, new SerializableCardViewModel(viewModel));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cards, container, false);
        SerializableCardViewModel viewModel =
                (SerializableCardViewModel) getArguments().getSerializable(VIEW_MODEL);
        TextView textView = (TextView) rootView.findViewById(R.id.title);
        textView.setText(viewModel.title());
        ImageView img = (ImageView) rootView.findViewById(R.id.img);
        try {
            img.setImageDrawable(
                    Drawable.createFromStream(
                            getContext().getAssets().open(
                                    viewModel.imgPath()),
                            null));

        } catch (IOException e) {
            img.setImageResource(R.drawable.broken_card_img);
        }

        return rootView;
    }
}
