package com.forbitbd.bcspreperation.ui.questionbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.forbitbd.bcspreperation.model.PreviousQuestionType;

import java.util.List;

public class QuestionBankAdapter extends RecyclerView.Adapter<QuestionBankAdapter.QuestionBankHolder> {

    private Context context;
    private List<PreviousQuestionType> previousQuestionTypeList;
    private QuestionBankClickListener listener;

    public QuestionBankAdapter(Context context, List<PreviousQuestionType> previousQuestionTypeList, QuestionBankClickListener listener) {
        this.context = context;
        this.previousQuestionTypeList = previousQuestionTypeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionBankHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_modeltext,parent,false);
        return new QuestionBankHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionBankHolder holder, int position) {
        PreviousQuestionType previousQuestionType = previousQuestionTypeList.get(position);
        holder.bind(previousQuestionType);
    }

    @Override
    public int getItemCount() {
        return previousQuestionTypeList.size();
    }

    public void AddCategory(PreviousQuestionType previousQuestionType) {
        previousQuestionTypeList.add(previousQuestionType);
        int position = previousQuestionTypeList.indexOf(previousQuestionType);
        notifyItemInserted(position);
    }

    public class QuestionBankHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        public QuestionBankHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(previousQuestionTypeList.get(getAdapterPosition()));
                }
            });

        }

        public void bind(PreviousQuestionType previousQuestionType) {
            img.setImageResource(R.drawable.logo);
            name.setText(previousQuestionType.getBangla_name());
        }
    }
}
