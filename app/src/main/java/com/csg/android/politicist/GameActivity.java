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

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d("GameActivity", "Line 19: Activity Created");
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(swipeAdapter);
        // set the page to the middle page because the user will have to swipe left and right
        mViewPager.setCurrentItem(1);
    }
    public class SwipeAdapter extends FragmentStatePagerAdapter{
        public SwipeAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int i){
            Fragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            Log.d("GameActivity", String.valueOf(i));
            bundle.putInt("pageNum", i);
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
