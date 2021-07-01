package com.forbitbd.bcspreperation.ui.question;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.forbitbd.bcspreperation.FragAdapter;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.Question;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.forbitbd.bcspreperation.ui.quiz.QuizFragment;
import com.forbitbd.bcspreperation.ui.result.ResultActivity;
import com.forbitbd.bcspreperation.utils.AdUtil;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends BaseActivity implements QuestionContract.View, View.OnClickListener {

    private QuestionPresenter mPresenter;
    private Category category;
    private SubCategory subCategory;
    private ViewPager viewPager;
    private FragAdapter adapter;
    private List<Question> questionList;
    private TextView tvCurrent, tvTotal;
    private RelativeLayout rIndicator;
    private int currentItem;
    private Button btnSubmit;
    public String SubcatId;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        mPresenter = new QuestionPresenter(this);
        this.questionList = new ArrayList<>();
        category = (Category) getIntent().getSerializableExtra(Constant.CATEGORY);
        subCategory = (SubCategory) getIntent().getSerializableExtra(Constant.SUBCATEGORY);
        SubcatId = subCategory.get_id();
        setupToolbar(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(subCategory.getName());

        adapter = new FragAdapter(getSupportFragmentManager());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                createAd();
            }
        });

        new AdUtil(this);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        mPresenter.getQuestions(SubcatId);
        rIndicator = findViewById(R.id.indicator);
        tvCurrent = findViewById(R.id.current);
        tvTotal = findViewById(R.id.total);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentItem = position;
                tvCurrent.setText(String.valueOf(position + 1));

                if (adapter.getItem(position) instanceof QuizFragment) {
                    QuizFragment qf = (QuizFragment) adapter.getItem(position);
                    qf.controlPrevNext(position, questionList.size());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startResultActivity();
    }

    private void startResultActivity() {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.QUESTION_LIST, (Serializable) questionList);
        bundle.putString(Constant.SUBCATEGORY, subCategory.getName());
        bundle.putSerializable(Constant.CATEGORY, category);
        bundle.putSerializable(Constant.SUBCATEGORY, subCategory);
        intent.putExtras(bundle);
        startActivity(intent);

        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        }

        finish();
    }

    @Override
    public void renderQuestion(List<Question> questionList) {
        this.questionList = questionList;

        tvTotal.setText(String.valueOf(questionList.size()));
        rIndicator.setVisibility(View.VISIBLE);

        for (int i = 0; i < questionList.size(); i++) {
            QuizFragment questionFragment = new QuizFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constant.QUESTION, questionList.get(i));
            questionFragment.setArguments(bundle);
            adapter.addFragment(questionFragment);
        }

        adapter.notifyDataSetChanged();
    }

    public void previous() {
        viewPager.setCurrentItem(currentItem - 1, true);
    }

    public void next() {
        viewPager.setCurrentItem(currentItem + 1, true);
    }

    public void updateQuestion(Question question) {
        this.questionList.set(currentItem, question);
    }

    private void createAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }
}