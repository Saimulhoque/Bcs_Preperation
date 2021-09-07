package com.forbitbd.bcspreperation.ui.previousquestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Order;
import com.forbitbd.bcspreperation.model.PreviousQuestion;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.util.List;

public class PreviousQuestionActivity extends BaseActivity implements PreviousQuestionContract.View{

    private PreviousQuestionPresenter mPresenter;
    private PreviousQuestionsAdapter adapter;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previousquestion);

        this.order = (Order) getIntent().getSerializableExtra(Constant.ORDER);
        mPresenter = new PreviousQuestionPresenter(this);

        setupToolbar(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(order.getBangla_name());

        PreviousQuestion previousQuestion = new PreviousQuestion();
        previousQuestion.setType(order.getType());
        previousQuestion.setOrder(order.getOrder());


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PreviousQuestionsAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.getPreviousQuestions(previousQuestion);
    }

    @Override
    public void renderQuestions(List<PreviousQuestion> previousQuestions) {
        for (PreviousQuestion x : previousQuestions) {
            adapter.AddQuestion(x);
        }
    }

    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterAdClose() {

    }
}
