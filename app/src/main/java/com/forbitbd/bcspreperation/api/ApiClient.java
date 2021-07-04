package com.forbitbd.bcspreperation.api;

import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.Question;
import com.forbitbd.bcspreperation.model.SubCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/bcs/category")
    Call<List<Category>> getAllCategory();

    @GET("/bcs/category/{id}/subcats")
    Call<List<SubCategory>> getAllSubcategory(@Path("id") String id);

    @GET("/bcs/subcategory/{id}/questions")
    Call<List<Question>> getAllQuestions(@Path("id") String id);

}
