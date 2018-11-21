package com.example.puza.nepmed.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.adapter.PopularAdapter;
import com.example.puza.nepmed.model.PopularItems;

import java.util.ArrayList;
import java.util.List;

public class PopularFragment extends Fragment {

    /*---------------Popular items----------------------*/
    RecyclerView allServiceRecyclerView;
    private RecyclerView.LayoutManager asLayoutManager;
    PopularAdapter allServicesAdapter;
    List<PopularItems> allServiceItems;
    /*---------------------------------------------------*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        /*------------------Popular List Items--------------------------*/
        allServiceRecyclerView = (RecyclerView) view.findViewById(R.id.popularRecyclerView);

        allServiceItems = getPopularItem();

        allServiceRecyclerView.setHasFixedSize(true);

        asLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        allServiceRecyclerView.setLayoutManager(asLayoutManager);
        allServicesAdapter = new PopularAdapter(getActivity(), allServiceItems);
        allServiceRecyclerView.setAdapter(allServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }

    private List<PopularItems> getPopularItem() {
        allServiceItems = new ArrayList<PopularItems>();

        allServiceItems.add(new PopularItems(R.drawable.ic_action_checkup, "Fitness"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_chemical, "Ayush"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_baby_care, "Personal Care"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_prescription, "Family Care"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_chemical, "Lifestyle"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_checkup, "Treatments"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_chemical, "Devices"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_heart_beat, "Blood bank"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_more, "Devices"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_prescription, "baby care"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_prescription, "Medicine"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_baby_care, "Fitness"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_checkup, "Treatments"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_chemical, "Devices"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_heart_beat, "Blood bank"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_more, "Devices"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_prescription, "baby care"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_profile, "Medicine"));
        allServiceItems.add(new PopularItems(R.drawable.ic_action_logout, "Fitness"));

        return allServiceItems;
    }

}
