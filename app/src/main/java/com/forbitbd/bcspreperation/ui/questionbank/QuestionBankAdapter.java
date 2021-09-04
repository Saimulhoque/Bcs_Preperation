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
import com.forbitbd.bcspreperation.model.QBCategory;

import java.util.List;

public class QuestionBankAdapter extends RecyclerView.Adapter<QuestionBankAdapter.QuestionBankHolder> {

    private Context context;
    private List<QBCategory> qbCategoryList;
    private QuestionBankClickListener listener;

    public QuestionBankAdapter(Context context, List<QBCategory> qbCategoryList, QuestionBankClickListener listener) {
        this.context = context;
        this.qbCategoryList = qbCategoryList;
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
        QBCategory qbCategory = qbCategoryList.get(position);
        holder.bind(qbCategory);
    }

    @Override
    public int getItemCount() {
        return qbCategoryList.size();
    }

    public void AddCategory(QBCategory qbCategory) {
        qbCategoryList.add(qbCategory);
        int position = qbCategoryList.indexOf(qbCategory);
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
                    listener.OnItemClick(qbCategoryList.get(getAdapterPosition()));
                }
            });

        }

        public void bind(QBCategory qbCategory) {
            img.setImageResource(R.drawable.logo);
            name.setText(qbCategory.getName());
        }
    }
}
