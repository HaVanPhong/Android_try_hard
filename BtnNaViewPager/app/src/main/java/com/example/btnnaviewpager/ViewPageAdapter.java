package com.example.btnnaviewpager;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new  fragment1();
            case 1:
                return new fragment2();

            case 2:
                return new fragment3();

            default:
                return new fragment1();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
