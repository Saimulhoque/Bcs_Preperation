package com.forbitbd.bcspreperation.ui.quiz;

public class QuizPresenter implements QuizContract.Presenter{

    private QuizContract.View mView;

    public QuizPresenter(com.forbitbd.bcspreperation.ui.quiz.QuizContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void performAction(int buttonId) {
        mView.performAction(buttonId);
    }
}
