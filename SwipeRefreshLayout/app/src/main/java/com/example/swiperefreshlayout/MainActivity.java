package com.example.swiperefreshlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recv);
        swipeRefreshLayout=findViewById(R.id.swipe);


        adapter=new ItemAdapter(this);
        adapter.setDate(CreateList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.pink));



    }

    @Override
    public void onRefresh() {
        adapter.setDate(CreateList());


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_left_to_right);
                recyclerView.setLayoutAnimation(layoutAnimationController);
            }
        }, 200);
    }
    public List<String> CreateList(){
        List<String> str1= new ArrayList<>();
        for (int i=0; i<15; i++){
            str1.add("ITEM "+i);
        }
        return str1;
    }
}