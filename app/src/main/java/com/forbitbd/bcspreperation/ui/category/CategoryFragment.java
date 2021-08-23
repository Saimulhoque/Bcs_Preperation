package com.forbitbd.bcspreperation.ui.category;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.ui.subcategory.SubCategoryActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements CategoryContract.View {

    private RecyclerView recyclerView;
    private ArrayList<Category> categoryList;
    private CategoryAdapter adapter;
    private CategoryPresenter mPresenter;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CategoryPresenter(this);

//        new AdUtil(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        mPresenter.getCategories();
        initView(view);

        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        categoryList = new ArrayList<>();
        adapter = new CategoryAdapter(getContext(), categoryList, new CatItemClickListener() {
            @Override
            public void onCatClick(Category category) {
                Intent intent = new Intent(getContext(), SubCategoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.CATEGORY, category);
//                bundle.getSerializable(Constant.SUBCATEGORY, category)
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void renderCategory(List<Category> categoryList) {
        for (Category x : categoryList) {
            adapter.AddCategory(x);
        }
    }
}