package com.forbitbd.bcspreperation.ui.study;

public class StudyPresenter implements StudyContract.Presenter{

    private StudyContract.View mView;

    public StudyPresenter(StudyContract.View mView) {
        this.mView = mView;
    }
}
