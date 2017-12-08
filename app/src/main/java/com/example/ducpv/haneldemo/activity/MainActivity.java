package com.example.ducpv.haneldemo.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.MyPagerAdapter;
import com.example.ducpv.haneldemo.customuis.NavigationLayoutGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;

    private NavigationLayoutGroup navigationLayoutGroup;

    private NavigationLayoutGroup.OnChildItemClickListener onNavigationBarPageChanged = new NavigationLayoutGroup.OnChildItemClickListener() {
        @Override
        public void onChildItemClick(View view, int position) {
            viewPager.setCurrentItem(position, false);
        }
    };
    private ViewPager.OnPageChangeListener onPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            navigationLayoutGroup.setSelectedItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationLayoutGroup = findViewById(R.id.nav_group);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(onPagerChangeListener);

        navigationLayoutGroup.setOnChildItemClickListener(onNavigationBarPageChanged);
    }
}
