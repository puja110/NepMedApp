package com.example.puza.serviceapp.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.adapter.PagerTabAdapter;

public class OrderFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    Dialog dialog;
    TextView filter;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);


        //Adding toolbar to the activity
//        Toolbar toolbar=(Toolbar)view.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("OPEN"));
        tabLayout.addTab(tabLayout.newTab().setText("COMPLETED"));
        tabLayout.addTab(tabLayout.newTab().setText("CANCELLED"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager=(ViewPager)view.findViewById(R.id.pager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Creating our pager adapter
        PagerTabAdapter adapter=new PagerTabAdapter(getFragmentManager(),tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);

        //filter dialog
        filter = (TextView)view.findViewById(R.id.filter);
        openFilterDialogue();

        return view;
    }

    public void openFilterDialogue(){

        // add listener to button
        filter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                dialog = new Dialog(getContext());
                // Include dialog.xml file
                dialog.setContentView(R.layout.fragment_filter);

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.show();

                ImageView cancel_filter = (ImageView) dialog.findViewById(R.id.cancel_filter);
                cancel_filter.setColorFilter(Color.WHITE);

                // if decline button is clicked, close the custom dialog
                cancel_filter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    // Close dialog
                    dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
