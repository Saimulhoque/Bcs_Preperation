package com.forbitbd.bcspreperation.ui.result;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.Question;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;


import java.util.List;

public class ResultActivity extends BaseActivity implements ResultContract.View{

    private List<Question> questionList;
    private Category category;

    private TextView tvTotal,tvAnswered,tvLeave,tvCorrect;
    private RecyclerView mRecyclerView;
    private QuestionsAdapter adapter;
    private ResultPresenter mPresenter;
    private String subCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mPresenter = new ResultPresenter(this);

        this.questionList = (List<Question>) getIntent().getSerializableExtra(Constant.QUESTION_LIST);
        this.subCategory = getIntent().getStringExtra(Constant.SUBCATEGORY);
        this.category = (Category) getIntent().getSerializableExtra(Constant.CATEGORY);

        setupToolbar(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Result");

        initView();
    }

    private void initView() {
        tvTotal = findViewById(R.id.total_questions);
        tvAnswered = findViewById(R.id.answered);
        tvLeave = findViewById(R.id.leave);
        tvCorrect = findViewById(R.id.correct_answer);

        mRecyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new QuestionsAdapter(this,questionList);
        mRecyclerView.setAdapter(adapter);

        mPresenter.renderResult(questionList);
    }

    @Override
    public void renderTotalTextView(String s) {
        tvTotal.setText(s);
    }

    @Override
    public void renderAnsweredTextView(String s) {
        tvAnswered.setText(s);
    }

    @Override
    public void renderLivedTextView(String s) {
        tvLeave.setText(s);
    }

    @Override
    public void renderCorrectAnswerTextView(String s) {
        tvCorrect.setText(s);
    }

    @Override
    public void afterAdClose() {

    }
}