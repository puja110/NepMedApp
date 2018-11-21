package com.example.puza.nepmed.fragment;

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
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.puza.nepmed.MainActivity;
import com.example.puza.nepmed.R;
import com.example.puza.nepmed.adapter.AddAdapter;
import com.example.puza.nepmed.adapter.HotDealsAdapter;
import com.example.puza.nepmed.adapter.LatestAdapter;
import com.example.puza.nepmed.adapter.OurPartnersAdapter;
import com.example.puza.nepmed.adapter.ServiceGridAdapter;
import com.example.puza.nepmed.adapter.ShopByCategoryAdapter;
import com.example.puza.nepmed.model.AddItems;
import com.example.puza.nepmed.model.HotDealsItems;
import com.example.puza.nepmed.model.LatestItems;
import com.example.puza.nepmed.model.OurPartnersItems;
import com.example.puza.nepmed.model.Service;
import com.example.puza.nepmed.model.ServiceItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    /*---------------Popular items----------------------*/
    RecyclerView addRecyclerView;
    private RecyclerView.LayoutManager addLayoutManager;
    AddAdapter addAdapter;
    List<AddItems> addItems;
    /*---------------------------------------------------*/

    /*---------------circle service items----------------------*/
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    ShopByCategoryAdapter adapter;
    List<ServiceItems> allItems;
    /*---------------------------------------------------*/

    /*---------------Latest items----------------------*/
    RecyclerView latestRecyclerView;
    private RecyclerView.LayoutManager latestLayoutManager;
    LatestAdapter latestAdapter;
    List<LatestItems>latestItems;
    /*---------------------------------------------------*/

    /*---------------Hot Deals items----------------------*/
    RecyclerView hotDealsRecyclerView;
    private RecyclerView.LayoutManager hotDealsLayoutManager;
    HotDealsAdapter hotDealsAdapter;
    List<HotDealsItems> hotDealsItems;
    /*---------------------------------------------------*/

    /*---------------Our Partners items----------------------*/
    RecyclerView ourPartnersRecyclerView;
    private RecyclerView.LayoutManager ourPartnersLayoutManager;
    OurPartnersAdapter ourPartnersAdapter;
    List<OurPartnersItems> ourPartnersItems;
    /*---------------------------------------------------*/



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
        recyclerViewGrid = (RecyclerView)view.findViewById(R.id.recyclerGrid);

        serviceGridList = new ArrayList<>();
        serviceAdapter = new ServiceGridAdapter(getContext(), serviceGridList);

        RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewGrid.setLayoutManager(gLayoutManager);
        recyclerViewGrid.addItemDecoration(new HomeFragment.GridSpacingItemDecoration(3, dpToPx(0),true));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrid.setAdapter(serviceAdapter);

        prepareServiceList();
        /*-----------------------service grid -------------------------------------*/

        /*------------------Add Items--------------------------*/
        addRecyclerView = (RecyclerView) view.findViewById(R.id.addRecyclerView);

        addItems = getAddItem();

        addRecyclerView.setHasFixedSize(true);

        addLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        addRecyclerView.setLayoutManager(addLayoutManager);
        addAdapter = new AddAdapter(getActivity(), addItems);
        addRecyclerView.setAdapter(addAdapter);

        /*------------------------------------------------------------*/

        /*-----------------------Circle image-------------------------------------*/
        recyclerView = (RecyclerView) view.findViewById(R.id.shopByCategoryRecyclerView);

        allItems = getAllItemList();

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new ShopByCategoryAdapter(getActivity(), allItems);
        recyclerView.setAdapter(adapter);
        /*------------------------------------------------------------*/

        /*------------------Latest Items--------------------------*/
        latestRecyclerView= (RecyclerView) view.findViewById(R.id.latestRecyclerView);

        latestItems = getLatestItem();

        latestRecyclerView.setHasFixedSize(true);

        latestLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        latestRecyclerView.setLayoutManager(latestLayoutManager);
        latestAdapter = new LatestAdapter(getActivity(), latestItems);
        latestRecyclerView.setAdapter(latestAdapter);

        /*------------------------------------------------------------*/

        /*------------------Hot Deals Items--------------------------*/
        hotDealsRecyclerView= (RecyclerView) view.findViewById(R.id.hotDealsRecyclerView);

        hotDealsItems = getHotDealsItem();

        hotDealsRecyclerView.setHasFixedSize(true);

        hotDealsLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        hotDealsRecyclerView.setLayoutManager(hotDealsLayoutManager);
        hotDealsAdapter = new HotDealsAdapter(getActivity(), hotDealsItems);
        hotDealsRecyclerView.setAdapter(hotDealsAdapter);
        /*------------------------------------------------------------*/

        /*------------------Our Partners Items--------------------------*/
        ourPartnersRecyclerView= (RecyclerView) view.findViewById(R.id.ourPartnersRecyclerView);

        ourPartnersItems = getOurPartnersItem();

        ourPartnersRecyclerView.setHasFixedSize(true);

        ourPartnersLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        ourPartnersRecyclerView.setLayoutManager(ourPartnersLayoutManager);
        ourPartnersAdapter = new OurPartnersAdapter(getActivity(), ourPartnersItems);
        ourPartnersRecyclerView.setAdapter(ourPartnersAdapter);
        /*------------------------------------------------------------*/

        return view;
    }

    /*-------------------------------Grid Service--------------------------------------*/
    private void prepareServiceList(){
        int[] serviceList = new int[]{

                R.drawable.prescription,
                R.drawable.checkup,
                R.drawable.nurse,
                R.drawable.baby_care,
                R.drawable.tooth,
                R.drawable.blood,
        };

        Service s =new Service("Prescription", serviceList[0]);
        serviceGridList.add(s);
        s =new Service("Treatments", serviceList[1]);
        serviceGridList.add(s);
        s =new Service("Nurses", serviceList[2]);
        serviceGridList.add(s);
        s =new Service("Baby Care", serviceList[3]);
        serviceGridList.add(s);
        s =new Service("Dental Care", serviceList[4]);
        serviceGridList.add(s);
        s =new Service("Blood Bank", serviceList[5]);
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
        file_maps.put("Prescription",R.drawable.image5);
        file_maps.put("Treatment",R.drawable.image5);
        file_maps.put("Baby care",R.drawable.image5);
        file_maps.put("Dental care", R.drawable.image5);
        file_maps.put("Blood bank", R.drawable.image5);

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

    /*-----------------------Add items-------------------------------------*/
    public List<AddItems>  getAddItem(){
        addItems = new ArrayList<AddItems>();

        addItems.add(new AddItems(R.drawable.asian_product));
        addItems.add(new AddItems(R.drawable.image1));
        addItems.add(new AddItems(R.drawable.image5));
        addItems.add(new AddItems(R.drawable.image4));

        return addItems;
    }
    /*------------------------------------------------------------*/

    private List<ServiceItems> getAllItemList() {
        allItems = new ArrayList<ServiceItems>();


        allItems.add(new ServiceItems(R.drawable.ic_action_prescription, "Prescription"));
        allItems.add(new ServiceItems(R.drawable.ic_action_checkup, "Treatments"));
        allItems.add(new ServiceItems(R.drawable.ic_action_chemical, "Chemicals"));

        allItems.add(new ServiceItems(R.drawable.ic_action_heart_beat, "Heartbeat"));
        allItems.add(new ServiceItems(R.drawable.ic_action_baby_care, "Dental Care"));
        allItems.add(new ServiceItems(R.drawable.ic_action_checkup, "Nurses"));

        allItems.add(new ServiceItems(R.drawable.ic_action_heart_beat, "Blood bank"));
        allItems.add(new ServiceItems(R.drawable.ic_action_prescription, "Prescription"));
        allItems.add(new ServiceItems(R.drawable.ic_action_chemical, "Chemicals"));
        allItems.add(new ServiceItems(R.drawable.ic_action_baby_care, "CheckUps"));

        return allItems;
    }

    public List<LatestItems> getLatestItem(){

        latestItems = new ArrayList<LatestItems>();

        latestItems.add(new LatestItems(R.drawable.image7, "Prescriptions", "Rs 101." +
                "7", "Rs 97.98","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.image7, "Treatment", "Rs 144.6", "Rs 126","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.image7, "Chemicals", "Rs 305", "Rs 280","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.image7, "Heartbeat", "Rs 280", "Rs 250","Add To Cart"));

        latestItems.add(new LatestItems(R.drawable.ic_action_prescription, "Prescriptions", "Rs 101.07", "Rs 97.98","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.ic_action_chemical, "Treatment", "Rs 144.60", "Rs 126.09","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.ic_action_baby_care, "Chemicals", "Rs 305", "Rs 280","Add To Cart"));
        latestItems.add(new LatestItems(R.drawable.ic_action_heart_beat, "Heartbeat", "Rs 280", "Rs 250","Add To Cart"));

        return latestItems;
    }


    public List<HotDealsItems> getHotDealsItem(){

        hotDealsItems = new ArrayList<HotDealsItems>();

        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_prescription, "Prescriptions", "Rs 101." +
                "7", "Rs 97.98","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_chemical, "Treatment", "Rs 144.6", "Rs 126","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_baby_care, "Chemicals", "Rs 305", "Rs 280","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_heart_beat, "Heartbeat", "Rs 280", "Rs 250","Add To Cart"));

        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_prescription, "Prescriptions", "Rs 101.07", "Rs 97.98","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_chemical, "Treatment", "Rs 144.60", "Rs 126.09","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_baby_care, "Chemicals", "Rs 305", "Rs 280","Add To Cart"));
        hotDealsItems.add(new HotDealsItems(R.drawable.ic_action_heart_beat, "Heartbeat", "Rs 280", "Rs 250","Add To Cart"));

        return hotDealsItems;
    }

    public List<OurPartnersItems> getOurPartnersItem(){

        ourPartnersItems = new ArrayList<OurPartnersItems>();

        ourPartnersItems.add(new OurPartnersItems(R.drawable.image3));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image6));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image2));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image6));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image2));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image2));
        ourPartnersItems.add(new OurPartnersItems(R.drawable.image2));

        return ourPartnersItems;
    }

}
