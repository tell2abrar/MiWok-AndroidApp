package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private  MediaPlayer myAudio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("otiiko", "two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("tolookosu", "three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("oyyisa", "four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("massokka", "five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("temokka", "six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("kenekaku", "seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("kawinta", "eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("wo'e", "nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("na'aacha", "ten",R.drawable.number_ten,R.raw.number_ten));



        WordAdapter myWordAdapter = new WordAdapter(this,words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(myWordAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                myAudio = MediaPlayer.create(NumbersActivity.this,word.getmAudioResource());

                //Take permission from the system for audio focus
                myAudio.start();
                myAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (myAudio != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            myAudio.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            myAudio = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();

    }
}