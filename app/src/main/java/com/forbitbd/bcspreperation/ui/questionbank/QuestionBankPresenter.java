package com.forbitbd.bcspreperation.ui.questionbank;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.QBCategory;
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
        apiClient.getAllQbCategory().enqueue(new Callback<List<QBCategory>>() {
            @Override
            public void onResponse(Call<List<QBCategory>> call, Response<List<QBCategory>> response) {
                if (response.isSuccessful()){
                    mView.renderCategory(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<QBCategory>> call, Throwable t) {

            }
        });
    }
}
