package com.csg.android.politicist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class ImageFragment extends Fragment {
    ImageView mImage;
    private int[] imageIds = {R.drawable.ic_star}; //array to hold ids of images to be loaded into the fragment
    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Bundle arguments can be retrieved here
        Bundle args = getArguments();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);


    }

}
