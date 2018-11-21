package com.example.puza.nepmed;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.puza.nepmed.fragment.AddressFragment;
import com.example.puza.nepmed.fragment.ContactUsFragment;
import com.example.puza.nepmed.fragment.HomeFragment;
import com.example.puza.nepmed.fragment.LatestActivityFragment;
import com.example.puza.nepmed.fragment.LogOutFragment;
import com.example.puza.nepmed.fragment.MoreFragment;
import com.example.puza.nepmed.fragment.OrderFragment;
import com.example.puza.nepmed.fragment.ProfileFragment;
import com.example.puza.nepmed.fragment.VoucherFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private static final String SELECTED_ITEM = "arg_selected_item";
//    private int mSelectedItem;

    Toolbar toolbar;

    //Navigation Drawer
    private DrawerLayout mDrawerLayout;
    private ImageView navigationMenu;

    public static android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide the soft keyboard from inside a fragment
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.frame_container)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_container,homeFragment,null);
            fragmentTransaction.commit();
        }

        /*------------------------------------ Navigation Drawer -----------------------------------*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationMenu = (ImageView)findViewById(R.id.navigationMenu);
        navigationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        /*--------------------------------------------------------------------------------------------*/

        ImageView add_to_cart = (ImageView)findViewById(R.id.add_to_cart);
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatestActivityFragment fragment = new LatestActivityFragment();
                FragmentTransaction transaction = (getSupportFragmentManager().beginTransaction());
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        showHome();
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putInt(SELECTED_ITEM, mSelectedItem);
//        super.onSaveInstanceState(outState);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        android.support.v4.app.Fragment fragment = null;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if(id == R.id.my_order){
//            fragment = new OrderFragment();
//            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new OrderFragment(),null).commit();

        }else if (id == R.id.my_profile){
            fragment = new ProfileFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.my_address){
            fragment = new AddressFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.my_voucher){
            fragment = new VoucherFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();

        }else if (id == R.id.contact_us){
            fragment = new ContactUsFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();

        }else if (id == R.id.more){
            fragment = new MoreFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();

        }else if (id == R.id.logout){
//            fragment = new LogOutFragment();
//            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();


        }

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    Fragment fragment = null;

    private void showHome(){
        fragment = new HomeFragment();
        if (fragment != null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frame_container, fragment, fragment.getTag()).commit();
        }
    }

    @Override
    public void onBackPressed() {
//        final Fragment fragment = fragmentManager.findFragmentById(R.id.frame_container);
//        if (fragment != null) {
//            fragmentManager.popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//
//        FragmentManager fm = getSupportFragmentManager();
//        fm.popBackStack();

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragment instanceof HomeFragment){
                super.onBackPressed(); //close aoo
            }
            else {
                showHome();
            }
        }
    }
}
