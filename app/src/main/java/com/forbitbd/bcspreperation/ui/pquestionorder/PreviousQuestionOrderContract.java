package com.forbitbd.bcspreperation.ui.pquestionorder;

import com.forbitbd.bcspreperation.model.Order;

import java.util.List;

public interface PreviousQuestionOrderContract {

    interface View{
        void renderOrders(List<Order> orders);
    }

    interface Presenter{
        void getAllOrders(Order order);
    }
}
