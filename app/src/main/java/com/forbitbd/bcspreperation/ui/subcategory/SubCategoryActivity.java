package com.forbitbd.bcspreperation.ui.subcategory;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.forbitbd.bcspreperation.ui.question.QuestionActivity;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryActivity extends BaseActivity implements SubCategoryContract.View,SubCatClickListener {

    private SubCategoryPresenter mPresenter;
    private RecyclerView recyclerView;
    private ArrayList<SubCategory> subCategoryList;
    private SubCategoryAdapter adapter;
    private Category category;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        mPresenter = new SubCategoryPresenter(this);
        category = (Category) getIntent().getSerializableExtra(Constant.CATEGORY);

        setupToolbar(R.id.toolbar);
        getSupportActionBar().setTitle(category.getName());

        String CatId = category.get_id();
        mPresenter.getSubcategory(CatId);

        recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        this.subCategoryList = new ArrayList<>();

        adapter = new SubCategoryAdapter(this,category.getImage());
        recyclerView.setAdapter(adapter);

        loadBannerAd(R.id.adView);
    }

    @Override
    public void renderSubcategory(List<SubCategory> subCategoryList) {
        for (SubCategory x : subCategoryList) {
            adapter.AddCategory(x);
        }
    }

    @Override
    public void subCatClick(SubCategory subCategory) {
        Intent intent = new Intent(SubCategoryActivity.this, QuestionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.CATEGORY,category);
        bundle.putSerializable(Constant.SUBCATEGORY,subCategory);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void afterAdClose() {

    }
}
