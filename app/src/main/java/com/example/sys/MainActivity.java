package com.example.sys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sys.tabMainFragments.FavFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fragment =  fm.findFragmentById(R.id.fragment_container);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        fragment = new MainFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();

                        break;
                    case R.id.action_search:
                        fragment = new SearchFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();

                        break;
                    case R.id.action_chat:
                        fragment = new ChatFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();

                        break;
                    case R.id.action_person:
                        fragment = new UserFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();

                        break;
                }
                return false;
            }
        });
//        if(savedInstanceState == null){
//            bottomNavigationView.setSelectedItemId(R.id.action_home);
//        }
    }
    }

