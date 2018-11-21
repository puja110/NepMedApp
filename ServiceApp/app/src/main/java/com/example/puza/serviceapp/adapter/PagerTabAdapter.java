package com.example.puza.serviceapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.puza.serviceapp.fragment.OrderCancelledFragment;
import com.example.puza.serviceapp.fragment.OrderCompletedFragment;
import com.example.puza.serviceapp.fragment.OrderOpenFragment;

import java.nio.ByteOrder;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                OrderOpenFragment orderOpenFragment = new OrderOpenFragment();
                return orderOpenFragment;
            case 1:
                OrderCompletedFragment orderCompletedFragment = new OrderCompletedFragment();
                return  orderCompletedFragment;
            case 2:
                OrderCancelledFragment orderCancelledFragment = new  OrderCancelledFragment();
                return  orderCancelledFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

    }
}
