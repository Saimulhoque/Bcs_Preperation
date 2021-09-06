package com.forbitbd.bcspreperation.ui.pquestionorder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Order;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class PreviousQuestionOrderFragment extends Fragment implements PreviousQuestionOrderContract.View{

    private PreviousQuestionOrderPresenter mPresenter;
    private PreviousQuestionOrderAdapter adapter;
    private PreviousQuestionType previousQuestionType;

    public PreviousQuestionOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new PreviousQuestionOrderPresenter(this);
        previousQuestionType = (PreviousQuestionType) getArguments().getSerializable(Constant.QBCATEGORY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_previous_question_order, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PreviousQuestionOrderAdapter();
        recyclerView.setAdapter(adapter);

        Order order = new Order();
        order.setType(previousQuestionType.getName());

        mPresenter.getAllOrders(order);
    }

    @Override
    public void renderOrders(List<Order> orders) {
        for (Order x : orders) {
            adapter.AddOrders(x);
        }
    }
}