package com.example.puza.nepmed.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.puza.nepmed.fragment.BrandsFragment;
import com.example.puza.nepmed.fragment.CategoriesFragment;
import com.example.puza.nepmed.fragment.PopularFragment;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);

        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PopularFragment popularFragment = new PopularFragment();
                return popularFragment;
            case 1:
                CategoriesFragment categoriesFragment = new CategoriesFragment();
                return categoriesFragment;
            case 2:
                BrandsFragment brandsFragment = new BrandsFragment();
                return brandsFragment;
                default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
