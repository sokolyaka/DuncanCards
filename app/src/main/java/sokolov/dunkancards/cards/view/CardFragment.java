package sokolov.dunkancards.cards.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import sokolov.dunkancards.R;

import static android.graphics.Bitmap.createScaledBitmap;
import static android.graphics.BitmapFactory.Options;
import static android.graphics.BitmapFactory.decodeStream;

public class CardFragment extends Fragment {

    private static final String VIEW_MODEL = "VIEW_MODEL";

    public static CardFragment newInstance(CardDisplayModel viewModel) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putSerializable(VIEW_MODEL, new SerializableCardDisplayModel(viewModel));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cards, container, false);

        SerializableCardDisplayModel viewModel =
                (SerializableCardDisplayModel) getArguments().getSerializable(VIEW_MODEL);

        bindTitle(rootView, viewModel);
        bindImg(rootView, viewModel, getContext());

        return rootView;
    }

    private static void bindImg(View rootView, SerializableCardDisplayModel viewModel, Context context) {
        ImageView img = (ImageView) rootView.findViewById(R.id.img);

        try {
            img.setAdjustViewBounds(true);

            Options opts = new Options();
            opts.inPurgeable = true;
            opts.inScaled = true;

            img.setImageBitmap(
                    createScaledBitmap(
                            decodeStream(
                                    context
                                            .getAssets()
                                            .open(
                                                    viewModel.imgPath()),
                                    null,
                                    opts),
                            img.getDrawable()
                                    .getIntrinsicWidth(),
                            img.getDrawable()
                                    .getIntrinsicHeight(),
                            true));

        } catch (IOException e) {
            img.setImageResource(R.drawable.broken_card_img);
        }
    }

    private static void bindTitle(View rootView, SerializableCardDisplayModel viewModel) {
        TextView textView = (TextView) rootView.findViewById(R.id.title);
        textView.setText(viewModel.title());
    }
}
