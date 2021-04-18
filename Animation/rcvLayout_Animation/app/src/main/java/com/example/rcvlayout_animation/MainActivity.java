package com.example.rcvlayout_animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    Button btnLR, btnRL, btnUD, btnDU;
    List<User> users = new LinkedList<>();
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy<0){
                    setAnimation(R.anim.layout_left_to_right);
                }
            }
        });





    }

    private List<User> creatUser() {
        List<User> users=new ArrayList<>();
        users.add(new User(R.drawable.hiticon, "Phong", "BK"));
        users.add(new User(R.drawable.htmlcss, "Nam", "NAM DINH"));
        users.add(new User(R.drawable.java, "Dong", "Lai chau"));
        users.add(new User(R.drawable.ic_launcher_background, "Phuong", "BK"));
        users.add(new User(R.drawable.ic_launcher_foreground, "Huyen", "BK"));
        users.add(new User(R.drawable.htmlcss, "Nam", "NAM DINH"));
        users.add(new User(R.drawable.java, "Dong", "Lai chau"));
        users.add(new User(R.drawable.ic_launcher_background, "Phuong", "BK"));
        users.add(new User(R.drawable.ic_launcher_foreground, "Huyen", "BK"));
        users.add(new User(R.drawable.htmlcss, "Nam", "NAM DINH"));
        users.add(new User(R.drawable.java, "Dong", "Lai chau"));
        users.add(new User(R.drawable.ic_launcher_background, "Phuong", "BK"));
        users.add(new User(R.drawable.ic_launcher_foreground, "Huyen", "BK"));
        return users;
    }

    private void AnhXa() {
        recyclerView = findViewById(R.id.recv);
        btnLR = findViewById(R.id.btn1);
        btnRL = findViewById(R.id.btn2);
        btnUD = findViewById(R.id.btn3);
        btnDU = findViewById(R.id.btn4);
        btnRL.setOnClickListener(this);
        btnLR.setOnClickListener(this);
        btnDU.setOnClickListener(this);
        btnUD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                setAnimation(R.anim.layout_left_to_right);
                break;
            case R.id.btn2:
                setAnimation(R.anim.layout_right_to_left);
                break;
            case R.id.btn3:
                setAnimation(R.anim.layout_up_to_down);
                break;
            case R.id.btn4:
                setAnimation(R.anim.layout_down_to_up);
                break;
            default:
                break;
        }
    }
    private void setAnimation(int animResource){
        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(this, animResource);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        userAdapter = new UserAdapter(creatUser(), this);
        recyclerView.setAdapter(userAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}