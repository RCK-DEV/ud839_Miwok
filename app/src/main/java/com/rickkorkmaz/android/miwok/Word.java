package com.rickkorkmaz.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    // Default translation for the word
    private String mDefaultTranslation;

    // Miwok translation for the word
    private String mMiwokTranslation;

    //  Image resource id for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Indicates that there's no image is set
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as english)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Create a new word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as english)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageId is the image resource id for the image of the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Returns the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Returns the image resource id of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for the word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
