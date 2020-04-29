package com.example.sys.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sys.R;
import com.example.sys.view.fragments.HomeFragment;
import com.example.sys.view.fragments.SearchFragment;
import com.example.sys.view.fragments.UserFragment;
import com.example.sys.view.utils.IMarked;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements IMarked {

    private HomeFragment fragmentAll = HomeFragment.newInstance(true);
    private HomeFragment fragmentMark = HomeFragment.newInstance(false);
    private SearchFragment searchFragment = new SearchFragment();
    private UserFragment userFragment = new UserFragment();

    public static FragmentManager fm;
    Fragment fragment = fragmentAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("sys").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "Subscribed";
                if(!task.isSuccessful()){
                    msg = "Not subscribed";
                }
            }
        });

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container,userFragment,"4").hide(userFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container,searchFragment,"3").hide(searchFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container,fragmentMark,"2").hide(fragmentMark).commit();
        fm.beginTransaction().add(R.id.fragment_container,fragmentAll,"1").commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        fm.beginTransaction()
                                .hide(fragment).show(fragmentAll).addToBackStack(null).commit();
                        fragment = fragmentAll;
                        return true;
                    case R.id.action_search:
                        fm.beginTransaction()
                                .hide(fragment).show(searchFragment).addToBackStack(null).commit();
                        fragment = searchFragment;
                        return true;
                    case R.id.action_bookmark:
                        fm.beginTransaction()
                                .hide(fragment).show(fragmentMark).addToBackStack(null).commit();
                        fragment = fragmentMark;
                        return true;
                    case R.id.action_person:
                        fm.beginTransaction()
                                .hide(fragment).show(userFragment).addToBackStack(null).commit();
                        fragment = userFragment;
                        return true;
                }
                return false;
            }
        });
        if(savedInstanceState == null){
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
    }

    @Override
    public void onUserMarked() {
        fragmentAll.updatePage();
        fragmentMark.updateMark();
    }
}

