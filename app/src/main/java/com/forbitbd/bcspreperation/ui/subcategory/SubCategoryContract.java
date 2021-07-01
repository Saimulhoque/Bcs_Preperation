package com.forbitbd.bcspreperation.ui.subcategory;

import com.forbitbd.bcspreperation.model.SubCategory;

import java.util.List;

public interface SubCategoryContract {

    interface Presenter{
       void getSubcategory(String CatId);
    }

    interface View{
        void renderSubcategory(List<SubCategory> subCategoryList);
    }
}
