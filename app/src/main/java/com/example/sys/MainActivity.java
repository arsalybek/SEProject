package com.example.sys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements IMarked {

    private HomeFragment fragmentAll = HomeFragment.newInstance(true);
    private HomeFragment fragmentMark = HomeFragment.newInstance(false);
    private SearchFragment searchFragment = new SearchFragment();
    private UserFragment userFragment = new UserFragment();

    public static FragmentManager fm;
    private Fragment fragment = fragmentAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                                .hide(fragment).show(fragmentAll).commit();
                        fragment = fragmentAll;
                        return true;
                    case R.id.action_search:
                        fm.beginTransaction()
                                .hide(fragment).show(searchFragment).commit();
                        fragment = searchFragment;
                        return true;
                    case R.id.action_bookmark:
                        fm.beginTransaction()
                                .hide(fragment).show(fragmentMark).commit();
                        fragment = fragmentMark;
                        return true;
                    case R.id.action_person:
                        fm.beginTransaction()
                                .hide(fragment).show(userFragment).commit();
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

