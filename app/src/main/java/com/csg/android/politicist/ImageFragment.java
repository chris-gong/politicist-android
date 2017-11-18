package com.csg.android.politicist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class ImageFragment extends Fragment {
    ImageView mImage;
    private int[] imageIds = {0, R.drawable.ic_star, 2}; //array to hold ids of images to be loaded into the fragment
    public ImageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Bundle arguments can be retrieved here
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        mImage = (ImageView) view.findViewById(R.id.image_display);
        Bundle args = getArguments();
        int imageId = imageIds[args.getInt("pageNum")];
        Log.d("ImageFragment", String.valueOf(imageId));
        mImage.setImageResource(imageId);
        // Inflate the layout for this fragment
        return view;


    }

}
