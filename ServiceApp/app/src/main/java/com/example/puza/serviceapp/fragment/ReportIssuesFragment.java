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
public class ReportIssuesFragment extends Fragment {


    public ReportIssuesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report_issues, container, false);
    }

}
