package com.forbitbd.bcspreperation.ui.result;


import com.forbitbd.bcspreperation.model.Question;

import java.util.List;

public interface ResultContract {

    interface Presenter {
        void renderResult(List<Question> questionList);
    }

    interface View {
        void renderTotalTextView(String s);
        void renderAnsweredTextView(String s);
        void renderLivedTextView(String s);
        void renderCorrectAnswerTextView(String s);
    }
}
