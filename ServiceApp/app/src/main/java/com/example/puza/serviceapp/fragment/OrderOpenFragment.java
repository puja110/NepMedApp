package com.example.puza.serviceapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.serviceapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderOpenFragment extends Fragment {


    public OrderOpenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_open, container, false);
    }

}
