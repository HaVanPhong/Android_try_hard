package com.example.rcvlayout_animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=users.get(position);
//        holder.imgAvt.setImageResource(user.getImg());

        holder.tvUsername.setText(user.getUsername());
        holder.tvAddress.setText(user.getAddress());

        Glide.with(context).load(user.getImg()).into(holder.imgAvt);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvt;
        TextView tvUsername, tvAddress;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvt=itemView.findViewById(R.id.imgAvt);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            tvUsername=itemView.findViewById(R.id.tvUsername);
        }
    }
}
