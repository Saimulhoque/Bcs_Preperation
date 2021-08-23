package com.forbitbd.bcspreperation.ui.study;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.StudyHolder> {


    @NonNull
    @Override
    public StudyAdapter.StudyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudyAdapter.StudyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StudyHolder extends RecyclerView.ViewHolder {

        public StudyHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
