package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    RadioGroup rdbGr1, rdbGr2, rdbGr3;
    RadioButton rdbVertical, rdbHorizontal, rdbNormal, rdbDepth, rdbZoomOut, rdbLeftToRight, rdbRightToLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ViewPager2_Adapter viewPager2_adapter = new ViewPager2_Adapter(this);
        viewPager2.setAdapter(viewPager2_adapter);

        rdbGr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbLeftToRight:
                        viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                        break;
                    case R.id.rdbRightToLeft:
                        viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                        break;
                }
            }
        });
        rdbGr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbVertical:
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                        break;
                    case R.id.rdbHoriantal:
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                        break;
                }
            }
        });

        rdbGr3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbNormal:
                        viewPager2.setPageTransformer(null);
                        break;
                    case R.id.rdbZoomOut:
                        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
                        break;
                    case R.id.rdbDepth:
                        viewPager2.setPageTransformer(new DepthPageTransformer());
                        break;
                }
            }
        });


    }

    private void AnhXa() {
        viewPager2 = findViewById(R.id.viewPager2);
        rdbGr1 = findViewById(R.id.rdbGr1);
        rdbGr2 = findViewById(R.id.rdbGr2);
        rdbGr3 = findViewById(R.id.rdbGr3);
        rdbVertical = findViewById(R.id.rdbVertical);
        rdbHorizontal = findViewById(R.id.rdbHoriantal);
        rdbNormal = findViewById(R.id.rdbNormal);
        rdbZoomOut = findViewById(R.id.rdbZoomOut);
        rdbDepth = findViewById(R.id.rdbDepth);
        rdbLeftToRight = findViewById(R.id.rdbLeftToRight);
        rdbRightToLeft = findViewById(R.id.rdbRightToLeft);
    }
}