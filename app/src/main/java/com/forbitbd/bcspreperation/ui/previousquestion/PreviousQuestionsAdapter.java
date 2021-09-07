package com.forbitbd.bcspreperation.ui.previousquestion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.PreviousQuestion;

import java.util.ArrayList;
import java.util.List;

public class PreviousQuestionsAdapter extends RecyclerView.Adapter<PreviousQuestionsAdapter.QuestionHolder> {

    private List<PreviousQuestion> previousQuestionList;

    public PreviousQuestionsAdapter() {
        this.previousQuestionList = new ArrayList<>();
    }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qbquestion,parent,false);
        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        PreviousQuestion previousQuestion = previousQuestionList.get(position);
        holder.bind(previousQuestion);

    }

    @Override
    public int getItemCount() {
        return previousQuestionList.size();
    }

    public void AddQuestion(PreviousQuestion previousQuestion) {
        previousQuestionList.add(previousQuestion);
        int position = previousQuestionList.indexOf(previousQuestion);
        notifyItemInserted(position);
    }

    public class QuestionHolder extends RecyclerView.ViewHolder {

        TextView tvQuestion, optOne, optTwo, optThree, optFour, optFive, tvAnswer;
        LinearLayout lone, ltwo, lthree, lfour, lfive;

        public QuestionHolder(@NonNull View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.question);
            optOne = itemView.findViewById(R.id.opt_one);
            optTwo = itemView.findViewById(R.id.opt_two);
            optThree = itemView.findViewById(R.id.opt_three);
            optFour = itemView.findViewById(R.id.opt_four);
            optFive = itemView.findViewById(R.id.opt_five);

            tvAnswer = itemView.findViewById(R.id.answer);

            lone = itemView.findViewById(R.id.layout_one);
            ltwo = itemView.findViewById(R.id.layout_two);
            lthree = itemView.findViewById(R.id.layout_three);
            lfour = itemView.findViewById(R.id.layout_four);
            lfive = itemView.findViewById(R.id.layout_five);

        }

        public void bind(PreviousQuestion previousQuestion) {

            tvQuestion.setText(previousQuestion.getQuestion());
            tvAnswer.setText(String.valueOf(previousQuestion.getAnswer()));

            if(previousQuestion.getOptions().length==2){
                optOne.setText(previousQuestion.getOptions()[0]);
                optTwo.setText(previousQuestion.getOptions()[1]);

                lone.setVisibility(View.VISIBLE);
                ltwo.setVisibility(View.VISIBLE);
                lthree.setVisibility(View.GONE);
                lfour.setVisibility(View.GONE);
                lfive.setVisibility(View.GONE);

            }else if(previousQuestion.getOptions().length==3){
                optOne.setText(previousQuestion.getOptions()[0]);
                optTwo.setText(previousQuestion.getOptions()[1]);
                optThree.setText(previousQuestion.getOptions()[2]);

                lone.setVisibility(View.VISIBLE);
                ltwo.setVisibility(View.VISIBLE);
                lthree.setVisibility(View.VISIBLE);
                lfour.setVisibility(View.GONE);
                lfive.setVisibility(View.GONE);

            }else if(previousQuestion.getOptions().length==4){
                optOne.setText(previousQuestion.getOptions()[0]);
                optTwo.setText(previousQuestion.getOptions()[1]);
                optThree.setText(previousQuestion.getOptions()[2]);
                optFour.setText(previousQuestion.getOptions()[3]);

                lone.setVisibility(View.VISIBLE);
                ltwo.setVisibility(View.VISIBLE);
                lthree.setVisibility(View.VISIBLE);
                lfour.setVisibility(View.VISIBLE);
                lfive.setVisibility(View.GONE);

            }else if(previousQuestion.getOptions().length==5) {
                optOne.setText(previousQuestion.getOptions()[0]);
                optTwo.setText(previousQuestion.getOptions()[1]);
                optThree.setText(previousQuestion.getOptions()[2]);
                optFour.setText(previousQuestion.getOptions()[3]);
                optFive.setText(previousQuestion.getOptions()[4]);

                lone.setVisibility(View.VISIBLE);
                ltwo.setVisibility(View.VISIBLE);
                lthree.setVisibility(View.VISIBLE);
                lfour.setVisibility(View.VISIBLE);
                lfive.setVisibility(View.VISIBLE);
            }
        }
    }
}
