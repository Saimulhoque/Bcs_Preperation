package com.forbitbd.bcspreperation.ui.previousquestion;

import com.forbitbd.bcspreperation.model.PreviousQuestion;

import java.util.List;

public interface PreviousQuestionContract {

    interface View{

        void renderQuestions(List<PreviousQuestion> previousQuestions);

        void showToast(String toastMessage);
    }

    interface Presenter{
        void getPreviousQuestions(PreviousQuestion previousQuestion);
//        void getPreviousQuestions(PreviousQuestion previousQuestion);
    }
}
