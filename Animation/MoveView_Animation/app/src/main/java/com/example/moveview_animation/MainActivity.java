package com.example.moveview_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView end;
    ImageView imgCart, view_animation;
    TextView tvCountCart;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        end=findViewById(R.id.end);
        imgCart=findViewById(R.id.imgCart);
        view_animation=findViewById(R.id.view_animation);
        tvCountCart=findViewById(R.id.tvCount);


        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tvCountCart.setText(i+"");
                AnimationUtils.translateAnimation(end, view_animation, imgCart, end, new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imgCart.setBackgroundResource(R.drawable.bg_xam_corner_20);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


    }
}