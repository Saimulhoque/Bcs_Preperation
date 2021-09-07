package com.forbitbd.bcspreperation.ui.questionbank;

import android.util.Log;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.PreviousQuestion;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionBankPresenter implements QuestionBankContract.Presenter{

    private QuestionBankContract.View mView;

    public QuestionBankPresenter(QuestionBankContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void getCategories() {
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getPreviousQuestionsTypes().enqueue(new Callback<List<PreviousQuestionType>>() {
            @Override
            public void onResponse(Call<List<PreviousQuestionType>> call, Response<List<PreviousQuestionType>> response) {
                if (response.isSuccessful()){
                    Log.d("JJJJJJ", "onResponse: Type of Questions Found! ");
                    mView.renderCategory(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PreviousQuestionType>> call, Throwable t) {

            }
        });
    }
}
