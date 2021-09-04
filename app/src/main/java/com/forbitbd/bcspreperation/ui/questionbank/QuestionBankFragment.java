package com.forbitbd.bcspreperation.ui.questionbank;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.QBCategory;
import com.forbitbd.bcspreperation.ui.qbsubcat.QBSubcatActivity;
import com.forbitbd.bcspreperation.ui.subcategory.SubCategoryActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankFragment extends Fragment implements QuestionBankContract.View {

    private QuestionBankPresenter mPresenter;
    private RecyclerView recyclerView;
    private ArrayList<QBCategory> qbCategoryList;
    private QuestionBankAdapter adapter;

    public QuestionBankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new QuestionBankPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_bank, container, false);

        mPresenter.getCategories();
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.qbCategoryList = new ArrayList<>();

        adapter = new QuestionBankAdapter(getContext(), qbCategoryList, new QuestionBankClickListener() {
            @Override
            public void OnItemClick(QBCategory qbCategory) {
                Intent intent = new Intent(getContext(), QBSubcatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.QBCATEGORY, qbCategory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void renderCategory(List<QBCategory> qbCategoryList) {
        for (QBCategory x : qbCategoryList ){
            adapter.AddCategory(x);
    }
    }
}
