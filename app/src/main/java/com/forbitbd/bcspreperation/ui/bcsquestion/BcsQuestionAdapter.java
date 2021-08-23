package com.forbitbd.bcspreperation.ui.bcsquestion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.BcsQuestion;

import java.util.List;

public class BcsQuestionAdapter extends RecyclerView.Adapter<BcsQuestionAdapter.BcsQuestionHolder> {

    private List<BcsQuestion> bcsQuestionList;

    public BcsQuestionAdapter(List<BcsQuestion> bcsQuestionList) {
        this.bcsQuestionList = bcsQuestionList;
    }

    @NonNull
    @Override
    public BcsQuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modeltext,parent,false);
        return new BcsQuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BcsQuestionHolder holder, int position) {
        BcsQuestion bcsQuestion = bcsQuestionList.get(position);
        holder.bind(bcsQuestion);
    }

    @Override
    public int getItemCount() {
        return bcsQuestionList.size();
    }

    public class BcsQuestionHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text,titlecat;

        public BcsQuestionHolder(@NonNull View itemView) {
            super(itemView);

            image =itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.title);
            titlecat = itemView.findViewById(R.id.cat_title);
        }

        public void bind(BcsQuestion bcsQuestion) {
            image.setImageResource(R.drawable.logo);
            text.setText(bcsQuestion.getTitle());
            titlecat.setText("প্রশ্ন ব্যাংক");
        }
    }
}
