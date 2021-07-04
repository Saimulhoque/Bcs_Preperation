package com.forbitbd.bcspreperation.ui.question;

import com.forbitbd.bcspreperation.model.Question;

import java.util.List;

public interface QuestionContract {

    interface Presenter{
        void getQuestions(String SubcatId);
        void showAd();
        void startResultActivity();
    }

    interface View{
        void renderQuestion(List<Question> body);
        void showAd();
        void startResultActivity();
    }
}
