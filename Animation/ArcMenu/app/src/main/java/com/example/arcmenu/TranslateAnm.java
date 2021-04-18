package com.example.arcmenu;

import android.content.Context;
import android.telephony.mbms.MbmsErrors;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.viewpager.widget.ViewPager;

public class TranslateAnm implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public TranslateAnm(Context context, View view){
        gestureDetector=new GestureDetector(context, new SimpleGestureDetector(view));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
    }

    private class SimpleGestureDetector extends GestureDetector.SimpleOnGestureListener{
        private View viewAnm;
        private Boolean isFinishAnm=true;

        public SimpleGestureDetector(View viewAnm) {
            this.viewAnm = viewAnm;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (distanceY > 0)
                hideView();
            else
                showView();
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        private void hideView(){
            if (viewAnm==null || viewAnm.getVisibility()==View.GONE)
                return;
            Animation animation1= AnimationUtils.loadAnimation(viewAnm.getContext(), R.anim.btn_down);
            animation1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    viewAnm.setVisibility(View.VISIBLE);
                    isFinishAnm=false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    viewAnm.setVisibility(View.GONE);
                    isFinishAnm=true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                    }
            });
            if (isFinishAnm){
                viewAnm.startAnimation(animation1);
            }

        }
        private void showView(){
            if (viewAnm==null || viewAnm.getVisibility()==View.VISIBLE)
                return;
            Animation animation= AnimationUtils.loadAnimation(viewAnm.getContext(), R.anim.btn_up);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    viewAnm.setVisibility(View.VISIBLE);
                    isFinishAnm=false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isFinishAnm=true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            if (isFinishAnm){
                viewAnm.startAnimation(animation);
            }
        }
    }


}