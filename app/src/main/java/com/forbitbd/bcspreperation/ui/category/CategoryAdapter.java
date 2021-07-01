package com.forbitbd.bcspreperation.ui.category;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private Context context;
    private List<Category> categoryList;
    private CatItemClickListener listener;

    public CategoryAdapter(Context context, List<Category> categoryList, CatItemClickListener listener) {
        this.context = context;
        this.categoryList = categoryList;
        this.listener = listener;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cat,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.CategoryHolder holder, int position) {

        Category category = categoryList.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void AddCategory(Category category) {
        categoryList.add(category);
        int position = categoryList.indexOf(category);
        notifyItemInserted(position);
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        public CategoryHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCatClick(categoryList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Category category) {
            Picasso.get().load(category.getImage()).into(image);
            title.setText(category.getName());
        }
    }
}
