package com.example.sys;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sys.model.User;
import org.jetbrains.annotations.NotNull;


public class UserDetailFragment extends Fragment {
    private User user;
    private ImageView userAvatar;
    private TextView userName,userSurname,userTeachSkill,userAge, userGender;
    private ImageButton backBtn,likeBtn;
    private RecyclerView skillRecyclerView,portfolioRecyclerView;
    private UserLearnSkillDetailAdapter userLearnSkillDetailAdapter;
    private DetailScrollView scrollView;

    public static UserDetailFragment newInstance(User user) {
        UserDetailFragment fragment = new UserDetailFragment();
        fragment.user = user;
        return fragment;
    }
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.user_detail, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        skillRecyclerView = v.findViewById(R.id.user_recycler_skill_detail);
        skillRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        skillRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));


        portfolioRecyclerView = v.findViewById(R.id.user_recycler_portfolio_detail);
        portfolioRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        portfolioRecyclerView.setAdapter(new UserPortfolioAdapter(user.getPortfolio()));

        userLearnSkillDetailAdapter = new UserLearnSkillDetailAdapter(user.getLearnerSkills());
        skillRecyclerView.setAdapter(userLearnSkillDetailAdapter);

        userAvatar = v.findViewById(R.id.user_avatar_detail);
        userAvatar.setImageResource(user.getAvatar());

        userName = v.findViewById(R.id.user_name_detail);
        userName.setText(user.getName());

        userSurname = v.findViewById(R.id.user_surname_detail);
        userSurname.setText(user.getSurname());

        userTeachSkill = v.findViewById(R.id.user_skill_detail);
        userTeachSkill.setText("TEACHES  " + user.getTeacherSkills().get(0).getName());

        userAge = v.findViewById(R.id.user_age_detail);
        userAge.setText(String.valueOf(user.getAge()));

        userGender = v.findViewById(R.id.user_gender_detail);
        userGender.setText(String.valueOf(user.getGender()));

        backBtn = v.findViewById(R.id.user_close_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        scrollView = v.findViewById(R.id.nested_scroll_view);

        final GestureDetector gesture = new GestureDetector(v.getContext(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {
                        final int SWIPE_MIN_DISTANCE = 200;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                getActivity().getSupportFragmentManager().popBackStack();
                            }

                        } catch (Exception e) {
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });
        scrollView.setDetector(gesture);
        return v;
    }
}
