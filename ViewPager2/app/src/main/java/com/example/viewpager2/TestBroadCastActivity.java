//package com.example.viewpager2;
//
//import android.content.IntentFilter;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//public class TestBroadCastActivity extends AppCompatActivity {
//    BroadCast broadCast;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.layout_fragment1);
//
////        broadCast=new BroadCast();
////        IntentFilter intentFilter=new IntentFilter("test.BroadCast");
////        registerReceiver(broadCast, intentFilter);
//        //bảo mật hơn
////        LocalBroadcastManager.getInstance(this).registerReceiver(broadCast, intentFilter);
//
//    }
//
////    @Override
////    protected void onStop() {
////        super.onStop();
//////        unregisterReceiver(broadCast);
////        //protected
////        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadCast);
////    }
//}
