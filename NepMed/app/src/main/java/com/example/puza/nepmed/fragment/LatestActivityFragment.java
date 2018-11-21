package com.example.puza.nepmed.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.adapter.LatestActivityAdapter;
import com.example.puza.nepmed.adapter.LatestAdapter;
import com.example.puza.nepmed.adapter.PopularAdapter;
import com.example.puza.nepmed.model.LatestActivityItems;
import com.example.puza.nepmed.model.PopularItems;

import java.util.ArrayList;
import java.util.List;

public class LatestActivityFragment extends Fragment {

    /*---------------Latest Activity items----------------------*/
    RecyclerView latestActivityRecyclerView;
    private RecyclerView.LayoutManager latestActivityLayoutManager;
    LatestActivityAdapter latestActivityAdapter;
    List<LatestActivityItems> latestActivityItems;
    /*---------------------------------------------------*/

    public LatestActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest_activity, container, false);


        /*------------------Latest Activity List Items--------------------------*/
        latestActivityRecyclerView = (RecyclerView) view.findViewById(R.id.latestActivityRecyclerView);

        latestActivityItems = getLatestActivityItem();

        latestActivityRecyclerView.setHasFixedSize(true);

        latestActivityLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        latestActivityRecyclerView.setLayoutManager(latestActivityLayoutManager);
        latestActivityAdapter = new LatestActivityAdapter(getActivity(), latestActivityItems);
        latestActivityRecyclerView.setAdapter(latestActivityAdapter);

        /*------------------------------------------------------------*/

        return view;
    }

    private List<LatestActivityItems> getLatestActivityItem() {
        latestActivityItems = new ArrayList<LatestActivityItems>();

        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_checkup, "Puja","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_chemical, "Ayush","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_baby_care, "Ram","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_prescription, "Hari","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_chemical, "Sita","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_checkup, "Riya","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_chemical, "Gita","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));
        latestActivityItems.add(new LatestActivityItems(R.drawable.ic_action_heart_beat, "Raesh","+977 9823789979", R.drawable.ic_action_search,"02:45 PM"));

        return latestActivityItems;
    }

}
