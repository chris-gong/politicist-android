package com.csg.android.politicist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageFragment extends Fragment {
    ImageView mImage;
    TextView mTimer;
    private int[] imageIds = {R.drawable.ic_democrat, R.drawable.ic_politician, R.drawable.ic_republican}; //array to hold ids of images to be loaded into the fragment
    public ImageFragment() {
        mImage = null;
        mTimer = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Bundle arguments can be retrieved here
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        mImage = (ImageView) view.findViewById(R.id.image_display);
        Bundle args = getArguments();
        int pageNum = args.getInt("pageNum");
        int imageId = imageIds[pageNum];
        if(pageNum == 1){
            mTimer = (TextView) view.findViewById(R.id.time_display);

        }
        Log.d("ImageFragment", String.valueOf(imageId));
        mImage.setImageResource(imageId);
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        // mTimer is only initialized for the fragment containing the politician image
        if(mTimer != null){
            Log.d("ImageFragment", "onActivityCreated 1");
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        // mTimer is only initialized for the fragment containing the politician image
        if(mTimer != null){
            Log.d("ImageFragment", "onStart 1");
            mTimer.setText("15");
            // initialize countdowntimer if the fragment selected was the politician fragment
            CountDownTimer clock = new CountDownTimer(15 * 1000, 1000){
                @Override
                public void onTick(long millisUntilFinished){
                    // every second, decrement the text showing in mTimer
                    mTimer.setText("" + millisUntilFinished/1000);
                    Log.d("ImageFragment", "millisUntilFinished: " + millisUntilFinished);
                }
                @Override
                public void onFinish(){
                    // once time runs out, move on to the next question
                    // for now, just go back to the main activity
                    // try catch block is needed in the cases where the user presses
                    // the back button or leaves the app to do other stuff after
                    // going on to the game activity page
                    try{
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
