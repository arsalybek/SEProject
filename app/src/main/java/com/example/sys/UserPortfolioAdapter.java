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

public class UserPortfolioAdapter extends RecyclerView.Adapter<UserPortfolioAdapter.UserDetailHolder> {
    private List<Integer> portfolio;

    public UserPortfolioAdapter(List<Integer> portfolio) {
        this.portfolio = portfolio;
    }

    @NonNull
    @Override
    public UserPortfolioAdapter.UserDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_detail_portfolio_row, parent, false);
        return new UserPortfolioAdapter.UserDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserPortfolioAdapter.UserDetailHolder holder, int position) {
        int i = portfolio.get(position);
        holder.portfolio.setImageResource(i);
    }

    @Override
    public int getItemCount() {
        return portfolio.size();
    }

    public class UserDetailHolder extends RecyclerView.ViewHolder {
        ImageView portfolio;

        public UserDetailHolder(@NonNull View itemView) {
            super(itemView);
            portfolio = itemView.findViewById(R.id.portfolio_img);
        }
    }
}
