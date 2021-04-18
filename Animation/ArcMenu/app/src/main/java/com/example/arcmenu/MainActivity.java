package com.example.arcmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sa90.materialarcmenu.ArcMenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.arcmenu.R.drawable.ic_baseline_video_call_24;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab1;
    ArcMenu arcMenu;
    RecyclerView recyclerView;
    List<User> users;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        createListUsers();
        UserAdapter adapter=new UserAdapter(users, MainActivity.this);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        recyclerView.setOnTouchListener(new TranslateAnm(this, arcMenu));


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0){
                    Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.btn_down);
                    arcMenu.startAnimation(animation);
                    arcMenu.setVisibility(View.GONE);

                }else{
                    Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.btn_up);
                    arcMenu.startAnimation(animation);
                    arcMenu.setVisibility(View.VISIBLE);

                }
            }
        });
//
//


    }

    private void createListUsers() {
        users=new LinkedList<>();
        for (int i=1; i<20; i++)
            users.add(new User("USERNAME "+i));
    }

    private void AnhXa() {
        fab1=findViewById(R.id.fab1);
        arcMenu=findViewById(R.id.arcMenu);
        recyclerView=findViewById(R.id.rcvUser);
    }
}