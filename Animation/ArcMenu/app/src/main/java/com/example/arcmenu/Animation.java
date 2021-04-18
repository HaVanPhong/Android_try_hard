package com.example.arcmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Animation extends AppCompatActivity {
    ImageView imageView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView=findViewById(R.id.imgTranslate);
        recyclerView=findViewById(R.id.rcvAni);
        List<User> users=create();
        UserAdapter adapter=new UserAdapter(users, this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final android.view.animation.Animation animaTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0) {
                    imageView.startAnimation(animaTranslate);
                }else {
                    animaTranslate.cancel();
                }

            }
        });
    }
    public List<User> create(){
        List<User> list=new ArrayList<>();
        for (int i=1; i<20; i++){
            list.add(new User("phong " +i));
        }
        return  list;
    }

}