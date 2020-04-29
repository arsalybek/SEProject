package com.example.sys.model;

import java.util.List;

enum Gender{
    FEMALE,
    MALE
}
public class User {
    private String name;
    private String surname;
    private Gender gender;
    private int age;
    private Double rating;
    private List<Integer> portfolio;
    private List<Skill>learnerSkills;
    private List<Skill>teacherSkills;
    private List<Skill>partnerSkills;
    private int avatar;
    private int bookmark;
    private boolean isMarked;

    public User(String name, String surname, Gender gender, int age, Double rating, List<Integer> portfolio, List<Skill> learnerSkills, List<Skill> teacherSkills, List<Skill> partnerSkills, int avatar,int bookmark,boolean isMarked) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.rating = rating;
        this.portfolio = portfolio;
        this.learnerSkills = learnerSkills;
        this.teacherSkills = teacherSkills;
        this.partnerSkills = partnerSkills;
        this.avatar = avatar;
        this.bookmark = bookmark;
        this.isMarked = isMarked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Integer> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Integer> portfolio) {
        this.portfolio = portfolio;
    }

    public List<Skill> getLearnerSkills() {
        return learnerSkills;
    }

    public void setLearnerSkills(List<Skill> learnerSkills) {
        this.learnerSkills = learnerSkills;
    }

    public List<Skill> getTeacherSkills() {
        return teacherSkills;
    }

    public void setTeacherSkills(List<Skill> teacherSkills) {
        this.teacherSkills = teacherSkills;
    }

    public List<Skill> getPartnerSkills() {
        return partnerSkills;
    }

    public void setPartnerSkills(List<Skill> partnerSkills) {
        this.partnerSkills = partnerSkills;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }
}

