package com.forbitbd.bcspreperation.ui.modeltest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.ModelTest;

import java.util.List;

public class ModelTestAdapter extends RecyclerView.Adapter<ModelTestAdapter.ModelTestHolder> {

    private List<ModelTest> modelTestList;
    private ModelTestClickListener listener;

    public ModelTestAdapter(List<ModelTest> modelTestList, ModelTestClickListener listener) {
        this.modelTestList = modelTestList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ModelTestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modeltext,parent,false);
        return new ModelTestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelTestHolder holder, int position) {
        ModelTest modelTest = modelTestList.get(position);
        holder.bind(modelTest);
    }

    @Override
    public int getItemCount() {
        return modelTestList.size();
    }

    public class ModelTestHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text,titlecat;

        public ModelTestHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(modelTestList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(ModelTest modelTest) {

        }
    }
}
