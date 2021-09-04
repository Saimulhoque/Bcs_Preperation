package com.forbitbd.bcspreperation.ui.qbsubcat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.QBCategory;
import com.forbitbd.bcspreperation.model.QBSubcategory;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.forbitbd.bcspreperation.ui.qbquestion.QBQuestionActivity;
import com.forbitbd.bcspreperation.ui.question.QuestionActivity;
import com.forbitbd.bcspreperation.ui.questionbank.QuestionBankClickListener;
import com.forbitbd.bcspreperation.ui.subcategory.SubCategoryActivity;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class QBSubcatActivity extends BaseActivity implements QBSubcatContract.View{

    private QBSubcatPresenter mPresenter;
    private RecyclerView recyclerView;
    private ArrayList<QBSubcategory> qbSubcategoryList;
    private QBSubcatAdapter adapter;
    private QBCategory qbCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qbsubcat);

        mPresenter = new QBSubcatPresenter(this);
        qbCategory = (QBCategory) getIntent().getSerializableExtra(Constant.QBCATEGORY);

        setupToolbar(R.id.toolbar);
        getSupportActionBar().setTitle(qbCategory.getName());

        String CatId = qbCategory.get_id();
        mPresenter.getQbSubcategory(CatId);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.qbSubcategoryList = new ArrayList<>();
        adapter = new QBSubcatAdapter(this, qbSubcategoryList, new QbSubCatClickListener() {
            @Override
            public void OnItemClick(QBSubcategory qbSubcategory) {
                Intent intent = new Intent(QBSubcatActivity.this, QBQuestionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.QBCATEGORY,qbCategory);
                bundle.putSerializable(Constant.QBSUBCATEGORY,qbSubcategory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void afterAdClose() {

    }

    @Override
    public void renderQbSubcategory(List<QBSubcategory> qbSubcategoryList) {
        for (QBSubcategory x : qbSubcategoryList) {
            adapter.AddCategory(x);
        }
    }
}
