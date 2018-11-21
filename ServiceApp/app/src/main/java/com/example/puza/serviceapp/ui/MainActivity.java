package com.example.puza.serviceapp.ui;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.fragment.CartFragment;
import com.example.puza.serviceapp.fragment.ChatFragment;
import com.example.puza.serviceapp.fragment.HomeFragment;
import com.example.puza.serviceapp.fragment.InviteFriendsFragment;
import com.example.puza.serviceapp.fragment.JobConfirmationFragment;
import com.example.puza.serviceapp.fragment.LogOutFragment;
import com.example.puza.serviceapp.fragment.NotificationFragment;
import com.example.puza.serviceapp.fragment.NotificationUserFragment;
import com.example.puza.serviceapp.fragment.OrderFragment;
import com.example.puza.serviceapp.fragment.ReportIssuesFragment;
import com.example.puza.serviceapp.fragment.ReviewFragment;
import com.example.puza.serviceapp.fragment.ScheduleAppointmentFragment;
import com.example.puza.serviceapp.fragment.SearchFragment;
import com.example.puza.serviceapp.fragment.SelectedListFragment;
import com.example.puza.serviceapp.fragment.TransactionFragment;
import com.example.puza.serviceapp.fragment.UserFragment;
import com.example.puza.serviceapp.fragment.WalletFragment;
import com.example.puza.serviceapp.helper.BottomNavigationHelper;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    FragmentTransaction transaction;

    Toolbar toolbar;
    ImageView backPress;

    //Navigation Drawer
    private DrawerLayout mDrawerLayout;
    private ImageView navigationMenu;

    boolean flag = false;

    ImageView man_user, notification, searchImage;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        final SearchView search =findViewById(R.id.search);
//
//        ImageView searchImage = (ImageView)findViewById(R.id.searchImage);
//        searchImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flag){
//                    // means true
//                    search.setVisibility(View.INVISIBLE);
//                    flag = false;
//                }
//                else{
//                    search.setVisibility(View.VISIBLE);
//                    flag = true;
//                }
//
//            }
//        });

        man_user = (ImageView)findViewById(R.id.man_user);
        man_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserFragment fragment = new UserFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        notification = (ImageView)findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUserFragment fragment = new NotificationUserFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        searchImage = (ImageView)findViewById(R.id.searchImage);
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment fragment = new SearchFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        /*--------------------------- Navigation Drawer --------------------------*/

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

        setUpBottomNavigation();

        /*--------------------------- Navigation Drawer --------------------------*/
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_view_item, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView)
//                MenuItemCompat.getActionProvider(searchItem);

//        searchView.setOnQueryTextListener(
//                new SearchView.OnQueryTextListener() {
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
//                        return false;
//                    }
//                }
//        );
//
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

//    @Override
//    public void onBackPressed() {
//        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
//        if (mSelectedItem != homeItem.getItemId()) {
//            // select home item
//            selectFragment(homeItem);
//        } else if (mSelectedItem == homeItem.getItemId()) {
//            onBackPressed();
//
//        }
//    }

//    @Override
//    public void onBackPressed() {
//
//        int count = getFragmentManager().getBackStackEntryCount();
//
//        if (count == 0) {
//            super.onBackPressed();
//            //additional code
//        } else {
//            getFragmentManager().popBackStack();
//        }
//
//    }

    private void setUpBottomNavigation() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(0));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }

    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment());
                transaction.addToBackStack(null);
                break;
            case R.id.menu_search:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new SelectedListFragment());
                transaction.addToBackStack(null);

                break;
            case R.id.menu_profile:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new JobConfirmationFragment());
                transaction.addToBackStack(null);

                break;
            case R.id.menu_more:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new ChatFragment());
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if(id == R.id.home){
            fragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.my_orders){
            fragment = new OrderFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.wallet){

            fragment = new WalletFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.transactions){

            fragment = new TransactionFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.chat){

            fragment = new ScheduleAppointmentFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.notification){

            fragment = new NotificationFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.reviews){

            fragment = new ReviewFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.invite_friends){

            fragment = new InviteFriendsFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.report_issues){

            fragment = new ReportIssuesFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.logout){

            fragment = new LogOutFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
