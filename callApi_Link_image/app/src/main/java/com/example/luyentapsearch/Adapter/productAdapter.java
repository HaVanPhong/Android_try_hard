package com.example.luyentapsearch.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.luyentapsearch.Model.product;
import com.example.luyentapsearch.R;

import java.util.List;

public class productAdapter extends BaseAdapter {
    List<product> list;
    Context context;
    int layout;

    public productAdapter(List<product> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= layoutInflater.inflate(layout, null);

        TextView tvTitle=convertView.findViewById(R.id.tvtitle);
        TextView tvPrice=convertView.findViewById(R.id.tvPrice);
        ImageView imgProdcut=convertView.findViewById(R.id.imgProduct);



        tvTitle.setText(list.get(position).getTitle()+"haha");
        tvPrice.setText(list.get(position).getPrice()+"vnd");
        Glide.with(convertView).load(list.get(position).getImageLink()).into(imgProdcut);

        return convertView;
    }

}
