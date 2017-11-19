package com.csg.android.politicist;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by User on 11/19/2017.
 */
// custom viewpager class to disable swiping when needed
public class GameViewPager extends ViewPager {
    private boolean swipeable;

    public GameViewPager(Context context){
        super(context);
        swipeable = true;
    }

    public GameViewPager(Context context, AttributeSet attrs){
        super(context, attrs);
        swipeable = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(swipeable){
            return super.onTouchEvent(e);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e){
        if(swipeable){
            return super.onInterceptTouchEvent(e);
        }
        else{
            return false;
        }
    }

    public void setSwipeable(boolean swipeable){
        this.swipeable = swipeable;
    }
}
