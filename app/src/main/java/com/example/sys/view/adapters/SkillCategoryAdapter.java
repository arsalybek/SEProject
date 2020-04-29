package com.example.sys.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sys.R;

import java.util.List;

public class SkillCategoryAdapter extends RecyclerView.Adapter<SkillCategoryAdapter.SkillCategoryHolder> {
    private List<String> categoryList;
    public SkillCategoryAdapter(List<String> categoryList){
        this.categoryList = categoryList;
    }
    @NonNull
    @Override
    public SkillCategoryAdapter.SkillCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_category_row,parent,false);
        return new SkillCategoryAdapter.SkillCategoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillCategoryAdapter.SkillCategoryHolder holder, int position) {
        String category = categoryList.get(position);
        holder.categoryRow.setText(category);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class SkillCategoryHolder extends RecyclerView.ViewHolder {
        TextView categoryRow;
        public SkillCategoryHolder(@NonNull View itemView) {
            super(itemView);
            categoryRow = itemView.findViewById(R.id.skill_category_row_name);
        }
    }
}
