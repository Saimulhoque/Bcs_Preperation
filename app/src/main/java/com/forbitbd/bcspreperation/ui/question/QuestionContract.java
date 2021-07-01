package com.forbitbd.bcspreperation.ui.question;

import com.forbitbd.bcspreperation.model.Question;

import java.util.List;

public interface QuestionContract {

    interface Presenter{
        void getQuestions(String SubcatId);
    }

    interface View{
        void renderQuestion(List<Question> body);
    }
}
