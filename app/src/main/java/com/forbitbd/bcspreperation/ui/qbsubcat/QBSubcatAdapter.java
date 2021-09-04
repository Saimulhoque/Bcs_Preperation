package com.forbitbd.bcspreperation.ui.qbsubcat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.QBCategory;
import com.forbitbd.bcspreperation.model.QBSubcategory;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.forbitbd.bcspreperation.ui.questionbank.QuestionBankClickListener;

import java.util.List;

public class QBSubcatAdapter extends RecyclerView.Adapter<QBSubcatAdapter.QBSubcatHolder> {

    private Context context;
    private List<QBSubcategory> qbSubcategoryList;
    private QbSubCatClickListener listener;

    public QBSubcatAdapter(Context context, List<QBSubcategory> qbSubcategoryList, QbSubCatClickListener listener) {
        this.context = context;
        this.qbSubcategoryList = qbSubcategoryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QBSubcatAdapter.QBSubcatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_modeltext,parent,false);
        return new QBSubcatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QBSubcatAdapter.QBSubcatHolder holder, int position) {
        QBSubcategory qbSubcategory = qbSubcategoryList.get(position);
        holder.bind(qbSubcategory);

    }

    @Override
    public int getItemCount() {
        return qbSubcategoryList.size();
    }

    public void AddCategory(QBSubcategory qbSubcategory) {
        qbSubcategoryList.add(qbSubcategory);
        int position = qbSubcategoryList.indexOf(qbSubcategory);
        notifyItemInserted(position);
    }

    public class QBSubcatHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        public QBSubcatHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(qbSubcategoryList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(QBSubcategory qbSubcategory) {
            img.setImageResource(R.drawable.logo);
            name.setText(qbSubcategory.getName());
        }
    }
}
