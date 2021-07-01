package com.forbitbd.bcspreperation.ui.question;


import android.util.Log;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter implements QuestionContract.Presenter{

    private QuestionContract.View mView;
    public QuestionPresenter(QuestionContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void getQuestions(String SubcatId) {
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getAllQuestions(SubcatId).enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if (response.isSuccessful()){
                    mView.renderQuestion(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {

            }
        });
    }
}
