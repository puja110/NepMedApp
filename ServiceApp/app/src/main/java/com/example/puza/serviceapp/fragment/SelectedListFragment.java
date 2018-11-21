package com.example.puza.serviceapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.adapter.SelectedListAdapter;
import com.example.puza.serviceapp.model.SelectedListItem;

import java.util.ArrayList;
import java.util.List;

public class SelectedListFragment extends Fragment {


    /*------------------- selected items ---------------------------*/

    RecyclerView selectedItemRecyclerView;
    private RecyclerView.LayoutManager selectedItemLayoutManager;
    SelectedListAdapter selectedListAdapter;
    List<SelectedListItem> selectedListItems;

    /*-------------------------------------------------------------*/

    public SelectedListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_list, container, false);

        /*------------------- selected items ---------------------------*/

        selectedItemRecyclerView = (RecyclerView)view.findViewById(R.id.selectedListRecyclerView);
        selectedListItems = getSelectedListItems();
        selectedItemRecyclerView.setHasFixedSize(true);
        selectedItemLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        selectedItemRecyclerView.setLayoutManager(selectedItemLayoutManager);
        selectedListAdapter = new SelectedListAdapter(selectedListItems, getActivity());
        selectedItemRecyclerView.setAdapter(selectedListAdapter);

        /*---------------------------------------------------------------*/
        return view;
    }

    private List<SelectedListItem> getSelectedListItems(){

        selectedListItems = new ArrayList<SelectedListItem>();

        selectedListItems.add(new SelectedListItem(R.drawable.tap, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.health_care, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.car_wash, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.fitness_support, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.shifting_and_renovation, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.car_wash, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.personal_training, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.tap, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.fitness_support, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.car_wash, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.electronics_and_gadgets, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.health_care, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));
        selectedListItems.add(new SelectedListItem(R.drawable.shifting_and_renovation, "Plumbing", "825 U.S. 1,Hodgdon, ME, USA", "Book Now","Deselect"));

        return selectedListItems;
    }
}
