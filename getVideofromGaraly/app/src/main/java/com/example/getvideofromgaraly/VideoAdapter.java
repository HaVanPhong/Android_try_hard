package com.example.getvideofromgaraly;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Activity activity;
    private List<Video> list;

    public VideoAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setData(List<Video> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        Video video= list.get(position);
//        if (video==null)
//            return;
        Glide.with(activity).load(video.getThumb()).into(holder.imgVideo);

        holder.itemlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, playVideo.class);
                intent.putExtra("path_video", video.getPath());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgVideo;
        RelativeLayout itemlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVideo=itemView.findViewById(R.id.imgVideo);
            itemlayout=itemView.findViewById(R.id.itemlayout);
        }
    }
}
