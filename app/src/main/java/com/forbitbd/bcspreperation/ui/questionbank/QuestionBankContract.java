package com.forbitbd.bcspreperation.ui.questionbank;

import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;


import java.util.List;

public interface QuestionBankContract {

    interface View{

        void renderCategory(List<PreviousQuestionType> body);
    }

    interface Presenter{

        void getCategories();
    }
}
