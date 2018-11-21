package com.example.puza.serviceapp.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.puza.serviceapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {

    private ImageView cancel_filter;

    public FilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        cancel_filter = (ImageView)view.findViewById(R.id.cancel_filter);
        cancel_filter.setColorFilter(Color.WHITE);

        return view;
    }

}
