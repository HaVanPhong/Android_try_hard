package com.example.viewpager2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    RadioGroup rdbGr1, rdbGr2, rdbGr3;
    RadioButton rdbVertical, rdbHorizontal, rdbNormal, rdbDepth, rdbZoomOut, rdbLeftToRight, rdbRightToLeft;
    BroadCast broadCast;
    FloatingActionButton fabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ViewPager2_Adapter viewPager2_adapter = new ViewPager2_Adapter(this);
        viewPager2.setAdapter(viewPager2_adapter);

//        setBroadCast();
//        fabAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("đấm nhau không")
//                        .setMessage("có thì có mà không cũng có ")
//                        .setPositiveButton("có", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                setBroadCast();
//                            }
//                        })
//                        .setNegativeButton("kó", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "không gửi dữ liệu", Toast.LENGTH_SHORT).show();
//
//                            }
//                        })
//                        .create();
//                alertDialog.show();
//            }
//        });

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

//    @Override
//    protected void onStop() {
//        super.onStop();
//        unregisterReceiver(broadCast);
//    }
//    private void setBroadCast(){
//        broadCast=new BroadCast();
//        IntentFilter intentFilter=new IntentFilter("android.net.com.CONNECTIVITY_CHANGE");
//
//        registerReceiver(broadCast, intentFilter);
//    }
//
//    private void sendDataBroadCast() {
////        broadCast=new BroadCast();
////        IntentFilter intentFilter=new IntentFilter("android.intent.action.AIRPLANE_MODE");
//        Intent intent=new Intent();
//        intent.setAction("test.BroadCast");
//        intent.putExtra("data", "values");
//        sendBroadcast(intent);
//        //bảo mật
////        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//
//
////        registerReceiver(broadCast, intentFilter);
//    }

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

        fabAdd=findViewById(R.id.fabAdd);

    }
}