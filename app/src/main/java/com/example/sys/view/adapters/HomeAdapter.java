package com.example.sys.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sys.view.utils.IMarked;
import com.example.sys.controller.MainActivity;
import com.example.sys.R;
import com.example.sys.view.fragments.UserDetailFragment;
import com.example.sys.model.Skill;
import com.example.sys.model.User;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.UserHolder>  {
    private List<User> usersList;
    private IMarked markListener;
    public HomeAdapter(List<User> usersList,IMarked markListener){
        this.usersList = usersList;
        this.markListener = markListener;
    }
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_row,parent,false);
        return new UserHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserHolder holder, int position) {
        final User user = usersList.get(position);
        Skill curSkill = user.getTeacherSkills().get(0);
        holder.name.setText(user.getName());
        holder.surname.setText(user.getSurname());
        holder.avatar.setImageResource(user.getAvatar());
        holder.skillName.setText(curSkill.getName());
        holder.rating.setText(String.valueOf(user.getRating()));

        holder.curView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetailFragment userDetailFragment = UserDetailFragment.newInstance(user);
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,userDetailFragment).addToBackStack(null).commit();
            }
        });
        holder.marked.setImageResource(user.getBookmark());

        holder.marked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.isMarked()) {
                    user.setMarked(true);
                    Log.d("HomeAdapter",String.valueOf(user.isMarked()));
                    holder.marked.setImageResource(R.drawable.ic_bookmark_filled);
                    user.setBookmark(R.drawable.ic_bookmark_filled);
                    if (markListener != null) {
                        markListener.onUserMarked();}
                }
                else {
                    user.setMarked(false);
                    Log.d("HomeAdapter",String.valueOf(user.isMarked()));
                    holder.marked.setImageResource(R.drawable.ic_bookmark);
                    user.setBookmark(R.drawable.ic_bookmark);
                    if (markListener != null) {
                        markListener.onUserMarked();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    static class UserHolder extends RecyclerView.ViewHolder {
        TextView name,surname,skillName, rating;
        ImageView avatar;
        ImageButton marked;
        View curView;
        UserHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.card_user_name);
            surname = itemView.findViewById(R.id.card_user_surname);
            skillName = itemView.findViewById(R.id.card_user_skill);
            avatar = itemView.findViewById(R.id.card_user_img);
            rating = itemView.findViewById(R.id.card_user_rating);
            marked = itemView.findViewById(R.id.user_mark_btn);
            curView = itemView;
        }
    }
}
