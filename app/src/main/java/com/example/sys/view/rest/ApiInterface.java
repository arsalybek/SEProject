package com.example.sys.view.rest;

import com.example.sys.model.Skill;
import com.example.sys.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("api/users/current")
    Call<User> getCurUser();
    @GET("api/users/current/portfolio")
    Call<String[]> getCurUserPortfolio();
    @GET("api/users/current/rating")
    Call<Integer> getCurUserRating();
    @POST("api/users/<int:user_id>/skills")
    Call<User[]> postUserSkillList();
    @GET("api/users/<int:user_id>/skills")
    Call<User[]> getUserSkillList();
    @GET("api/categories/<int:category_id>")
    Call<Skill[]> getSkillCategory();
    @GET("api/users/top_ten")
    Call<User[]> getTopTenUsers();
    @PUT("api/skills/top_ten")
    Call<Skill[]> putTopSkills();
    @GET("api/categories")
    Call<Skill[]> getCategoryList();
    @GET("api/categories/<int:category_id>/skills")
    Call<String[]> getCategorySkills();




}
