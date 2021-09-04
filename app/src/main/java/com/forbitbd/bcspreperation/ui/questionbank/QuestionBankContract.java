package com.forbitbd.bcspreperation.ui.questionbank;

import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.QBCategory;

import java.util.List;

public interface QuestionBankContract {

    interface View{

        void renderCategory(List<QBCategory> body);
    }

    interface Presenter{

        void getCategories();
    }
}
