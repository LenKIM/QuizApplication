package com.android.len.myquizapplication;

/**
 * Created by len on 2017. 12. 4..
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    private boolean isCheated;

    public Question(int mTextResId, boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean isCheated() {
        return isCheated;
    }

    public void setCheated(boolean cheated) {
        isCheated = cheated;
    }
}
