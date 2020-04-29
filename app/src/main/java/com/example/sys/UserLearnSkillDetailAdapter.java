package com.example.sys;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sys.model.Skill;

import java.util.List;

class UserLearnSkillDetailAdapter extends RecyclerView.Adapter<UserLearnSkillDetailAdapter.UserDetailHolder> {
    private List<Skill> learnerSkills;
    public UserLearnSkillDetailAdapter(List<Skill> learnerSkills){
        this.learnerSkills = learnerSkills;
    }
    @NonNull
    @Override
    public UserLearnSkillDetailAdapter.UserDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_detail_learn_skill_row,parent,false);
        return new UserDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserLearnSkillDetailAdapter.UserDetailHolder holder, int position) {
        Skill skill = learnerSkills.get(position);
        holder.lsName.setText(skill.getName());
        holder.lsCategory.setText(skill.getCategory());
        holder.lsImg.setImageResource(skill.getImage());
    }

    @Override
    public int getItemCount() {
        return learnerSkills.size();
    }

    public class UserDetailHolder extends RecyclerView.ViewHolder {
        TextView lsName, lsCategory, lsDescription;
        ImageView lsImg;
        public UserDetailHolder(@NonNull View itemView) {
            super(itemView);
            lsName = itemView.findViewById(R.id.user_learn_skill_name);
            lsCategory = itemView.findViewById(R.id.user_learn_skill_category);
            lsImg = itemView.findViewById(R.id.user_learn_skill_img);
        }
    }
}
