package com.forbitbd.bcspreperation.ui.pquestionorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.Order;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class PreviousQuestionOrderActivity extends AppCompatActivity implements PreviousQuestionOrderContract.View{

    private PreviousQuestionType previousQuestionType;
    private RecyclerView recyclerView;
    private PreviousQuestionOrderPresenter mPresenter;
    private PreviousQuestionOrderAdapter adapter;
    private ArrayList<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_question_order);
        mPresenter = new PreviousQuestionOrderPresenter(this);
        this.previousQuestionType = (PreviousQuestionType) getIntent().getSerializableExtra(Constant.QBCATEGORY);

        Order order = new Order();
        order.setType(previousQuestionType.getName());

        mPresenter.getAllOrders(order);

        initView();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        orderList = new ArrayList<>();
        adapter = new PreviousQuestionOrderAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void renderOrders(List<Order> orders) {
        for (Order x : orders) {
            adapter.AddOrders(x);
        }
    }
}