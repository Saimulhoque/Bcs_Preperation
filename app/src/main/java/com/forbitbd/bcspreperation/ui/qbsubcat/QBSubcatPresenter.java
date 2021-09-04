package com.forbitbd.bcspreperation.ui.qbsubcat;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.QBSubcategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QBSubcatPresenter implements QBSubcatContract.Presenter{

    private QBSubcatContract.View mView;

    public QBSubcatPresenter(QBSubcatContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getQbSubcategory(String catId) {
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getAllQbSubcategory(catId).enqueue(new Callback<List<QBSubcategory>>() {
            @Override
            public void onResponse(Call<List<QBSubcategory>> call, Response<List<QBSubcategory>> response) {
                if (response.isSuccessful()) {
                    mView.renderQbSubcategory(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<QBSubcategory>> call, Throwable t) {

            }
        });
    }
}
