package com.csg.android.politicist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends FragmentActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
    }
    public class SwipeAdapter extends FragmentStatePagerAdapter{
        public SwipeAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int i){
            Fragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            return fragment;
        }
        @Override
        public int getCount(){
            // method used to return the number of pages
            return 3;
        }
    }
}
