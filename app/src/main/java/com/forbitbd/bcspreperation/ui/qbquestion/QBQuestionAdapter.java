package com.forbitbd.bcspreperation.ui.qbquestion;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QBQuestionAdapter extends RecyclerView.Adapter<QBQuestionAdapter.QBQuestionHolder> {


    @NonNull
    @Override
    public QBQuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QBQuestionHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class QBQuestionHolder extends RecyclerView.ViewHolder {

        public QBQuestionHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
