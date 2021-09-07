package com.forbitbd.bcspreperation.ui.pquestionorder;

import android.util.Log;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousQuestionOrderPresenter implements PreviousQuestionOrderContract.Presenter {

    private PreviousQuestionOrderContract.View mView;

    public PreviousQuestionOrderPresenter(PreviousQuestionOrderContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAllOrders(Order order) {
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getAllOrders(order).enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful()){
                    Log.d("JJJJJ", "onResponse: "+order.getType());
                    mView.renderOrders(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });
    }
}