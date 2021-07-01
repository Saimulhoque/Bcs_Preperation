package com.forbitbd.bcspreperation.ui.category;

import com.forbitbd.bcspreperation.model.Category;

import java.util.List;

public interface CategoryContract {

    interface Presenter{
        void getCategories();
    }

    interface View{
        void renderCategory(List<Category> body);
    }
}
