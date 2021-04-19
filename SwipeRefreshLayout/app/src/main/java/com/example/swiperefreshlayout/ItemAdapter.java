package com.example.swiperefreshlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<String> strings;
    Context context;

    public ItemAdapter( Context context) {
        this.context = context;
    }
    public void setDate(List<String> strings){
        this.strings=strings;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String str=strings.get(position);
        holder.tvItem.setText(str);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem=itemView.findViewById(R.id.tvItem);
        }
    }
}
