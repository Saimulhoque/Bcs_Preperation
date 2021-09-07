package com.forbitbd.bcspreperation.ui.pquestionorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Order;

import java.util.ArrayList;
import java.util.List;

public class PreviousQuestionOrderAdapter extends RecyclerView.Adapter<PreviousQuestionOrderAdapter.OrderHolder> {

    private List<Order> orderList;
    private PreviousQuestionClickListener listener;

    public PreviousQuestionOrderAdapter(PreviousQuestionClickListener listener) {
        this.listener = listener;
        this.orderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modeltext,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order = orderList.get(position);
        holder.bind(order);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void AddOrders(Order order) {
        orderList.add(order);
        int position = orderList.indexOf(order);
        notifyItemInserted(position);
    }

    public class OrderHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(orderList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Order order) {
            image.setImageResource(R.drawable.logo);
            text.setText(order.getBangla_name());
        }
    }
}
