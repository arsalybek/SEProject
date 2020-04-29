package com.example.sys.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sys.R;
import com.example.sys.view.adapters.SkillCategoryAdapter;
import com.example.sys.model.Skill;
import com.example.sys.model.UserContainer;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    RecyclerView recyclerView;
    UserContainer userContainer = UserContainer.get();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recycler_skill_category);

        SkillCategoryAdapter adapter = new SkillCategoryAdapter(getCategoryList(userContainer.getSkillList()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    List<String> getCategoryList(List<Skill> skillList){
        List<String> categoryList = new ArrayList<>();
        for(Skill s : skillList){
            categoryList.add(s.getCategory());
        }
        Log.e("SearchFragment",categoryList.toString());
        return categoryList;
    }
}
