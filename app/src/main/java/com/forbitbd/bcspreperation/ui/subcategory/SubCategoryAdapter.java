package com.forbitbd.bcspreperation.ui.subcategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.SubCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder> {

    private List<SubCategory> subCategoryList;
    private SubCatClickListener listener;
    private String image;

    public SubCategoryAdapter(SubCatClickListener listener,String image) {
        this.subCategoryList = new ArrayList<>();
        this.listener = listener;
        this.image = image;
    }

    @Override
    public SubCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new SubCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoryHolder holder, int position) {
        SubCategory subCategory = subCategoryList.get(position);
        holder.bind(subCategory);

    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }

    public void AddCategory(SubCategory subCategory) {
        subCategoryList.add(subCategory);
        int position = subCategoryList.indexOf(subCategory);
        notifyItemInserted(position);
    }

    public class SubCategoryHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;

        public SubCategoryHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.subCatClick(subCategoryList.get(getAdapterPosition()));
                }
            });

        }
        public void bind(SubCategory subCategory) {
            Picasso.get().load(image).into(imageView);
            name.setText(subCategory.getName());
        }
    }
}
