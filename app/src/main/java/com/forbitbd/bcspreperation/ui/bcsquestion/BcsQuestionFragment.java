package com.forbitbd.bcspreperation.ui.bcsquestion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.BcsQuestion;
import com.forbitbd.bcspreperation.model.ModelTest;
import com.forbitbd.bcspreperation.ui.modeltest.ModelTestAdapter;
import com.forbitbd.bcspreperation.ui.modeltest.ModelTestClickListener;

import java.util.ArrayList;


public class BcsQuestionFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<BcsQuestion> bcsQuestionList;
    private BcsQuestionAdapter adapter;

    public BcsQuestionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_bcs_question, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        bcsQuestionList = new ArrayList<>();
        bcsQuestionList.add(new BcsQuestion("","১১ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১২ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৩ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৪ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৫ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৬ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৭ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৮ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","১৯ তম বিসিএস পরীক্ষার প্রশ্ন"));
        bcsQuestionList.add(new BcsQuestion("","২০ তম বিসিএস পরীক্ষার প্রশ্ন"));

        adapter = new BcsQuestionAdapter(bcsQuestionList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}