package com.forbitbd.bcspreperation.api;

import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.Order;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;
import com.forbitbd.bcspreperation.model.QBSubcategory;
import com.forbitbd.bcspreperation.model.Question;
import com.forbitbd.bcspreperation.model.SubCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiClient {

//    @GET("/category")
//    Call<List<Category>> getAllCategory();
//
//    @GET("/category/{id}/subcats")
//    Call<List<SubCategory>> getAllSubcategory(@Path("id") String id);
//
//    @GET("/subcategory/{id}/questions")
//    Call<List<Question>> getAllQuestions(@Path("id") String id);
//
//    @GET("/qbcategory")
//    Call<List<QBCategory>> getAllQbCategory();
//
//    @GET("/qbcategory/{id}/subcats")
//    Call<List<QBSubcategory>> getAllQbSubcategory(@Path("id") String id);



    @GET("/bcs/category")
    Call<List<Category>> getAllCategory();

    @GET("/bcs/category/{id}/subcats")
    Call<List<SubCategory>> getAllSubcategory(@Path("id") String id);

    @GET("/bcs/subcategory/{id}/questions")
    Call<List<Question>> getAllQuestions(@Path("id") String id);

    @GET("/bcs/questions-bank/types")
    Call<List<PreviousQuestionType>> getPreviousQuestionsTypes();

    @POST("/bcs/questions-bank/orders")
    Call<List<Order>> getAllOrders(@Body Order order);

//    @POST("/bcs/questions-bank/orders")
//    Call<List<Order>> getAllOrders(@Body Order order);

    @GET("/bcs/qbcategory/{id}/subcats")
    Call<List<QBSubcategory>> getAllQbSubcategory(@Path("id") String id);
}
