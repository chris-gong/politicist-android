package com.csg.android.politicist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.*;
import android.util.Log;

public class GameActivity extends FragmentActivity {

    GameViewPager mViewPager;
    private SwipeAdapter swipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d("GameActivity", "Line 19: Activity Created");
        mViewPager = (GameViewPager) findViewById(R.id.view_pager);
        swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(swipeAdapter);
        // set the page to the middle page because the user will have to swipe left and right
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // when the user swipes to an fragment with an answer image, then disable swiping
                if(position % 2 == 0){
                    mViewPager.setSwipeable(false);
                    // after 3 seconds, redirect the user to the main activity
                    // note that this way only works well on the UI thread
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run(){
                            Intent intent = new Intent(GameActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }, 3000);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
