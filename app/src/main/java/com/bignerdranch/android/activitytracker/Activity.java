package com.bignerdranch.android.activitytracker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Nick030 on 4/10/2017.
 *
 * This Class contains information about the activity.
 *
 * Crime.java
 *
 */

public class Activity {
    private UUID mID;
    private String mTitle;
    private String mLocation;
    private String mActivityComment;
    private String mDuration;
    private Date mDate;

    private String mName;
    private String mEmail;
    private String mGender;
    private String mComment;




//    private boolean mSolved;

    public Activity(){
        this(UUID.randomUUID());
    }

    public Activity(UUID id){
        mID = id;
        mDate = new Date();
    }

    public String getPhotoFilename(){
        return"IMG_" + getId().toString() + ".jpg";
    }

    public UUID getId() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getActivityComment() {
        return mActivityComment;
    }

    public void setActivityComment(String activitycomment) {
        mActivityComment = activitycomment;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }



    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getComment() {
        return mGender;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
