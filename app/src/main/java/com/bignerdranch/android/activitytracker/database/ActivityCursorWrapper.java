package com.bignerdranch.android.activitytracker.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.activitytracker.Activity;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.ActivityTable;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.UserInfoTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Nick030 on 13/10/2017.
 */

public class ActivityCursorWrapper extends CursorWrapper {
    public ActivityCursorWrapper(Cursor cursor){
        super(cursor);
    }

    //below had two options may cause issues in future
    public Activity getActivity() {
        String uuidString = getString(getColumnIndex(ActivityTable.Cols.UUID));
        String title = getString(getColumnIndex(ActivityTable.Cols.TITLE));
        String location = getString(getColumnIndex(ActivityTable.Cols.LOCATION));
        String activitycomment = getString(getColumnIndex(ActivityTable.Cols.COMMENT));
        String duration = getString(getColumnIndex(ActivityTable.Cols.DURATION));
        long date = getLong(getColumnIndex(ActivityTable.Cols.DATE));

        Activity activity = new Activity(UUID.fromString(uuidString));
        activity.setTitle(title);
        activity.setLocation(location);
        activity.setActivityComment(activitycomment);
        activity.setDuration(duration);
        activity.setDate(new Date(date));

        return activity;
    }

    public Activity getSettings() {
        String uuidString = getString(getColumnIndex(UserInfoTable.Cols.UUID));
        String name = getString(getColumnIndex(UserInfoTable.Cols.NAME));
        String email = getString(getColumnIndex(UserInfoTable.Cols.EMAIL));
        String gender = getString(getColumnIndex(UserInfoTable.Cols.GENDER));
        String comment = getString(getColumnIndex(UserInfoTable.Cols.COMMENT));

        Activity activity = new Activity(UUID.fromString(uuidString));
        activity.setName(name);
        activity.setEmail(email);
        activity.setGender(gender);
        activity.setComment(comment);

        return activity;
    }
}
