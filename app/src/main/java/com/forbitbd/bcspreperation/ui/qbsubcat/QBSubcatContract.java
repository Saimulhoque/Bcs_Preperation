package com.forbitbd.bcspreperation.ui.qbsubcat;

import com.forbitbd.bcspreperation.model.QBSubcategory;

import java.util.List;

public interface QBSubcatContract {

    interface View{

        void renderQbSubcategory(List<QBSubcategory> body);
    }

    interface Presenter{

        void getQbSubcategory(String catId);
    }
}
