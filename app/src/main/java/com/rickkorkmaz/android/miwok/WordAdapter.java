package com.rickkorkmaz.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int mListItemBackGroundColorResourceId;

    public WordAdapter(@NonNull Context context, @NonNull List<Word> words) {
        super(context, 0, words);
    }

    public WordAdapter(@NonNull Context context, @NonNull List<Word> words, int listItemBackgroundColorResourceId) {
        super(context, 0, words);
        mListItemBackGroundColorResourceId = listItemBackgroundColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        // Check if view is being reused. Otherwise inflate new View-object from a XML-layout file.
        if (listItemView == null) {
            listItemView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultTranslationTextView = listItemView.findViewById(R.id.default_translation_text);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationTextView = listItemView.findViewById(R.id.miwok_translation_text);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        ImageView wordImageView = listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word
            wordImageView.setImageResource(currentWord.getImageResourceId());

            // Make sure the ImageView is set to visible. Reason being that
            // due to the fact that views get reused and thus if a recycled
            // view was set INVISIBLE or GONE we need to make it VISIBLE again.
            wordImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (Set visiblity to GONE)
            wordImageView.setVisibility(View.GONE);
        }

        RelativeLayout textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(mListItemBackGroundColorResourceId);

        return listItemView;
    }
}
