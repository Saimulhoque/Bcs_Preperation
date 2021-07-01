package com.forbitbd.bcspreperation.ui.quiz;

public interface QuizContract {
    interface Presenter{
        void performAction(int i);
    }

    interface View{
        void performAction(int buttonId);
    }
}
