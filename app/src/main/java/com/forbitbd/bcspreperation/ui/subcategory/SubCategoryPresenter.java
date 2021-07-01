package com.forbitbd.bcspreperation.ui.subcategory;

import com.forbitbd.bcspreperation.api.ApiClient;
import com.forbitbd.bcspreperation.api.ServiceGenerator;
import com.forbitbd.bcspreperation.model.SubCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryPresenter implements SubCategoryContract.Presenter{

    private SubCategoryContract.View mView;

    public SubCategoryPresenter(SubCategoryContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void getSubcategory(String CatId) {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getAllSubcategory(CatId).enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                if (response.isSuccessful()){
                    mView.renderSubcategory(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {

            }
        });
    }
}
