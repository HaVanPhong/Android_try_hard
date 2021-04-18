package com.example.slideimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    PhotoAdapter adapter;
    List<Photo> list=getListPhoto();
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pt_viewPager);
        circleIndicator = findViewById(R.id.circle_indicator);

        adapter = new PhotoAdapter(this, list);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImg();

    }

    private List<Photo> getListPhoto() {
        List<Photo> photos = new ArrayList<>();

        photos.add(new Photo("https://res.cloudinary.com/djowq0mq4/image/upload/v1616341553/sy1cv6xz5oa3gm9idpea.jpg"));
        photos.add(new Photo("https://res.cloudinary.com/djowq0mq4/image/upload/v1616341568/srrordvn445ptrkx9dvz.jpg"));
        photos.add(new Photo("https://res.cloudinary.com/djowq0mq4/image/upload/v1616341490/p7ieulm0p52vob7nysil.jpg"));
        photos.add(new Photo("https://res.cloudinary.com/djowq0mq4/image/upload/v1615873579/ivsoirii1e6rowrtks1q.jpg"));
        return photos;
    }
    private  void autoSlideImg(){
        if (list.isEmpty())
            return;
        if (timer==null)
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem =list.size()-1;
                        if (currentItem<totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else
                        {
                            viewPager.setCurrentItem(0);
                        }

                    }
                });
            }
        }, 500, 3000 );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }
}