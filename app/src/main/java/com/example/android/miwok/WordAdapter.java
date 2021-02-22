package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    private Context mContext;
    private ArrayList<Word> mWords;
    private int mBackground;

    WordAdapter(Context context, ArrayList<Word> words,int background){
        super(context,0,words);
        mContext = context;
        mWords = words;
        mBackground = background;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout,parent,false);
        }

        Word currentWord = (Word) mWords.get(position);

        TextView miwokTranslation =(TextView) listView.findViewById(R.id.miwok_translation);
        TextView defaultTranslation = (TextView) listView.findViewById(R.id.default_translation);
        ImageView imageView = (ImageView) listView.findViewById(R.id.images);
        RelativeLayout translationLayout = (RelativeLayout) listView.findViewById(R.id.translation_layout);

        if (currentWord.getmImageSource()!=-1){
            imageView.setImageResource(currentWord.getmImageSource());
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        miwokTranslation.setText(currentWord.getmMiwokTranslation());
        defaultTranslation.setText(currentWord.getmDefaultTranslation());

        //Check the below code in internet to understand fullly
        int color = ContextCompat.getColor(getContext(),mBackground);
        translationLayout.setBackgroundColor(color);


        return listView;

    }
}
