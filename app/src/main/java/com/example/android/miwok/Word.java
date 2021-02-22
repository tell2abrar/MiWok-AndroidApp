package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageSource;
    private int mAudioResource;

    Word(String miwokWord,String defaultWord,int audioResource){
        this.mMiwokTranslation = miwokWord;
        this.mDefaultTranslation = defaultWord;
        mImageSource = -1;
        mAudioResource = audioResource;
    }

    Word(String miwokWord,String defaultWord,int imageSource ,int audioResource){
        this.mMiwokTranslation = miwokWord;
        this.mDefaultTranslation = defaultWord;
        mImageSource = imageSource;
        mAudioResource = audioResource;
    }

    public String getmMiwokTranslation() {

        return mMiwokTranslation;
    }

    public String getmDefaultTranslation() {

        return mDefaultTranslation;
    }

    public int getmImageSource() {

        return mImageSource;
    }

    public int getmAudioResource() {
        return mAudioResource;
    }
}
