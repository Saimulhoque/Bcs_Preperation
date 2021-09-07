package com.forbitbd.bcspreperation.ui.previousquestion;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.PreviousQuestion;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousQuestionPresenter implements PreviousQuestionContract.Presenter{

    private PreviousQuestionContract.View mView;

    public PreviousQuestionPresenter(PreviousQuestionContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getPreviousQuestions(PreviousQuestion previousQuestion) {
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getAllPreviousQuestions(previousQuestion).enqueue(new Callback<List<PreviousQuestion>>() {
            @Override
            public void onResponse(Call<List<PreviousQuestion>> call, Response<List<PreviousQuestion>> response) {
                if (response.isSuccessful()){
                    mView.renderQuestions(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PreviousQuestion>> call, Throwable t) {
               mView.showToast("Error: "+t.getMessage());
            }
        });
    }
}