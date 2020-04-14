package com.example.sys;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sys.tabMainFragments.FavFragment;
import com.example.sys.tabMainFragments.HomeFragment;
import com.example.sys.tabUserFragments.LearnerFragment;
import com.example.sys.tabUserFragments.PartnerFragment;
import com.example.sys.tabUserFragments.TeacherFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    FavFragment mFavFragment;
    HomeFragment mHomeFragment;
    TabLayout mTabLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        ViewPager viewPager = view.findViewById(R.id.view_pager);

        mTabLayout = view.findViewById(R.id.tabLayout);
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), 0, getFragments()));
        mTabLayout.setupWithViewPager(viewPager);
        setupTabTexts();
        return view;
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        mFavFragment = new FavFragment();
        mHomeFragment = new HomeFragment();

        fragments.add(mFavFragment);
        fragments.add(mHomeFragment);

        return fragments;
    }

    private void setupTabTexts() {
        mTabLayout.getTabAt(0).setText("HOME");
        mTabLayout.getTabAt(1).setText("MY LIST");
    }
}
