package com.example.sys.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sys.R;
import com.example.sys.controller.MainActivity;
import com.example.sys.model.User;
import com.example.sys.model.UserContainer;
import com.example.sys.view.adapters.HomeAdapter;
import com.example.sys.view.utils.IMarked;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements IMarked {
    private UserContainer userContainer = UserContainer.get();
    private List<User> dataSet = new ArrayList<>();
    private boolean isAllUsers;
    private HomeAdapter adapter;

    public static HomeFragment newInstance(boolean isAllUsers) {
        HomeFragment fragment = new HomeFragment();
        fragment.isAllUsers = isAllUsers;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_teachers);

        if (isAllUsers) {
            dataSet.addAll(userContainer.getDataset());
        } else {
            dataSet.addAll(userContainer.getMarkedUsers());
            Log.d("HomeFragment",userContainer.getMarkedUsers().toString());
        }
        adapter = new HomeAdapter(dataSet, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        new LinearSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onUserMarked() {
        ((MainActivity) getActivity()).onUserMarked();
    }
    public void updateMark(){
        dataSet.clear();
        dataSet.addAll(userContainer.getMarkedUsers());
        Log.d("HomeFragment",userContainer.getMarkedUsers().toString());
        adapter.notifyDataSetChanged();
    }
    public void updatePage(){
        dataSet.clear();
        dataSet.addAll(userContainer.getDataset());
        adapter.notifyDataSetChanged();
    }
}
