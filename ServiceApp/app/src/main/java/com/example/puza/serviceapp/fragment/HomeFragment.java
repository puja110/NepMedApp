package com.example.puza.serviceapp.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.adapter.ServiceGridAdapter;
import com.example.puza.serviceapp.model.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

//    Unbinder unbinder;

//    @BindView(R.id.search)
//    EditText search;

//    @BindView(R.id.textview_service)
//    TextView textview_service;

//    @BindView(R.id.see_all_one)
//    TextView see_all_one;
//
//    @BindView(R.id.see_all_two)
//    TextView see_all_two;

    //slider
    private SliderLayout mDemoSlider;
    private LinearLayout mLinearLayout;

    /*---------------service grid items----------------------*/
    private RecyclerView recyclerViewGrid;
    private ServiceGridAdapter serviceAdapter;
    private List<Service> serviceGridList;
    /*--------------- service items----------------------*/


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // bind view using butter knife
//        unbinder = ButterKnife.bind(this, view);

        //hide the soft keyboard from inside a fragment
//        getActivity().getWindow().setSoftInputMode(
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //slider
        mDemoSlider = (SliderLayout)view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();


        /*-----------------------service grid -------------------------------------*/
        recyclerViewGrid = (RecyclerView) view.findViewById(R.id.recyclerGrid);

        serviceGridList = new ArrayList<>();
        serviceAdapter = new ServiceGridAdapter(getContext(), serviceGridList);

        RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(getContext(), 4);
        recyclerViewGrid.setLayoutManager(gLayoutManager);
        recyclerViewGrid.addItemDecoration(new HomeFragment.GridSpacingItemDecoration(3, dpToPx(0),true));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrid.setAdapter(serviceAdapter);

        prepareServiceList();
        /*-----------------------service grid -------------------------------------*/

        return view;
    }

    /*-------------------------------Grid Service--------------------------------------*/
    private void prepareServiceList(){
        int[] serviceList = new int[]{

                R.drawable.tap,
                R.drawable.car_wash,
                R.drawable.health_care,
                R.drawable.electronics_and_gadgets,
                R.drawable.personal_training,
                R.drawable.business_support,
                R.drawable.shifting_and_renovation,
                R.drawable.electronics_and_gadgets,
                R.drawable.fitness_support,
                R.drawable.shifting_and_renovation,
                R.drawable.electronics_and_gadgets,
                R.drawable.fitness_support,
        };

        Service s =new Service("Plumbing", serviceList[0]);
        serviceGridList.add(s);
        s =new Service("Car Wash", serviceList[1]);
        serviceGridList.add(s);
        s =new Service("Health Care", serviceList[2]);
        serviceGridList.add(s);
        s =new Service("Electronics and Gadgets", serviceList[3]);
        serviceGridList.add(s);
        s =new Service("Personal training", serviceList[4]);
        serviceGridList.add(s);
        s =new Service("Business Support", serviceList[5]);
        serviceGridList.add(s);
        s =new Service("Shifting and Renovation", serviceList[6]);
        serviceGridList.add(s);
        s =new Service("Gadgets repair", serviceList[7]);
        serviceGridList.add(s);
        s =new Service("Fitness Support", serviceList[8]);
        serviceGridList.add(s);
        s =new Service("Shifting and Renovation", serviceList[6]);
        serviceGridList.add(s);
        s =new Service("Gadgets repair", serviceList[7]);
        serviceGridList.add(s);
        s =new Service("Fitness Support", serviceList[8]);
        serviceGridList.add(s);

        serviceAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean inclidEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean inclidEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.inclidEdge = inclidEdge;
        }

        public void getItemOffsets(Rect outrect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item columns

            if (inclidEdge){
                outrect.left = spacing - column * spacing / spanCount;
                outrect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount){
                    outrect.top = spacing;
                }
                outrect.bottom = spacing;
            }else {
                outrect.left = column * spacing / spanCount;
                outrect.right = spacing - (column + 1) * spacing / spanCount;
                if(position>=spanCount){
                    outrect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /*------------------------------------------------------------------------------------------*/

    //slider
    private void setupSlider() {
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Cleaning",R.drawable.banner);
        file_maps.put("Repair",R.drawable.banner2);
        file_maps.put("Washing",R.drawable.banner4);
        file_maps.put("Plumber", R.drawable.banner);
        file_maps.put("Repair", R.drawable.banner2);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2000);
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        // unbind the view to free some memory
//        unbinder.unbind();
//    }
}
