package com.forbitbd.bcspreperation.ui.study;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.ui.quiz.QuizPresenter;

public class StudyFragment extends Fragment implements StudyContract.View {


    private StudyPresenter mPresenter;

    public StudyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new StudyPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        return view;
    }


}