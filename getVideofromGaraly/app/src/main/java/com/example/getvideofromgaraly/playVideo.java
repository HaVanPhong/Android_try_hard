package com.example.getvideofromgaraly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;

public class playVideo extends AppCompatActivity {
    MxVideoPlayerWidget videoPlayerWidget;

    @Override
    protected void onPause() {
        super.onPause();
        MxVideoPlayer.releaseAllVideos();
    }

//    @Override
//    public void onBackPressed() {
//        if (MxVideoPlayer.backPress())
//            return;
//        super.onBackPressed();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent=getIntent();
        String pathVideo = intent.getStringExtra("path_video");

        videoPlayerWidget=findViewById(R.id.mx_video_player);
        videoPlayerWidget.startPlay(pathVideo, MxVideoPlayer.SCREEN_LAYOUT_NORMAL, "video 1");





    }
}