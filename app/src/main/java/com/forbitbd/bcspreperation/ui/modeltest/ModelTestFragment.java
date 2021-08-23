package com.forbitbd.bcspreperation.ui.modeltest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.ModelTest;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.forbitbd.bcspreperation.ui.subcategory.SubCatClickListener;

import java.util.ArrayList;

public class ModelTestFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<ModelTest> modelTestList;
    private ModelTestAdapter adapter;

    public ModelTestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_model_test, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        modelTestList = new ArrayList<>();
        modelTestList.add(new ModelTest("মডেল টেষ্ট","৪১ তম বিসিএস স্পেশাল সাজেশন"));
        modelTestList.add(new ModelTest("মডেল টেষ্ট","৪১ তম বিসিএস এর বাংলা ব্যাকরণ সাজেশন"));
        modelTestList.add(new ModelTest("মডেল টেষ্ট","৪১ তম বিসিএস বাংলা সাজেশন"));
        modelTestList.add(new ModelTest("মডেল টেষ্ট","৪১ তম বিসিএস ইংরেজি সাজেশন"));

        adapter = new ModelTestAdapter(modelTestList, new ModelTestClickListener() {
            @Override
            public void OnItemClick(ModelTest modelTest) {
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}