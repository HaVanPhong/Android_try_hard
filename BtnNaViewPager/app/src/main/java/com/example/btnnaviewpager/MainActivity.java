package com.example.btnnaviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNavi;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNavi = findViewById(R.id.bottomnavi);
        viewPager = findViewById(R.id.viewpager);

        setupViewPager();

        btnNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_favorite:
                        viewPager.setCurrentItem(1);
                        Toast.makeText(MainActivity.this, "favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_myPage:
                        viewPager.setCurrentItem(2);
                        Toast.makeText(MainActivity.this, "my page", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    void setupViewPager() {
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        btnNavi.getMenu().findItem(R.id.action_home).setChecked(true);
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        btnNavi.getMenu().findItem(R.id.action_favorite).setChecked(true);
                        Toast.makeText(MainActivity.this, "fovorite", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        btnNavi.getMenu().findItem(R.id.action_myPage).setChecked(true);
                        Toast.makeText(MainActivity.this, "my page", Toast.LENGTH_SHORT).show();
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}