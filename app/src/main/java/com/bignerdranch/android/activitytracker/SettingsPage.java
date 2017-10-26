package com.bignerdranch.android.activitytracker;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.bignerdranch.android.activitytracker.database.ActivityBaseHelper;
import com.bignerdranch.android.activitytracker.database.ActivityCursorWrapper;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nick030 on 19/10/2017.
 */

public class SettingsPage {
    private static SettingsPage sSettingPage;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static SettingsPage get(Context context){
        if(sSettingPage == null){
            sSettingPage = new SettingsPage(context);
        }
        return sSettingPage;
    }

    private SettingsPage(Context context){
        mContext = context.getApplicationContext();
//        mDatabase = new ActivityBaseHelper(mContext).getWritableDatabase();
    }

//    public List<Activity> getActivities(){
//        List<Activity> activities = new ArrayList<>();
//
//        ActivityCursorWrapper cursor = queryActivities(null, null);
//
//        try{
//            cursor.moveToFirst();
//            while(!cursor.isAfterLast()){
//                activities.add(cursor.getActivity());
//                cursor.moveToNext();
//            }
//        }finally{
//            cursor.close();
//        }
//        return activities;
//    }

//    public Activity getSetting(UUID id){
//        Log.d("getString: ", id.toString());
//        ActivityCursorWrapper cursor = queryActivities(
//                ActivityDbSchema.UserInfoTable.Cols.UUID + " = ?",
//                new String[] {id.toString()}
//        );
//
//        try{
//            if(cursor.getCount() == 0){
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getSettings();
//        }finally{
//            cursor.close();
//        }
//
//    }

//    public Activity getSettings(UUID id){
//        ActivityCursorWrapper cursor = queryActivities(
//                ActivityDbSchema.UserInfoTable.Cols.UUID + " = ?",
//                new String[] {id.toString()}
//        );
//
//        try{
//            if(cursor.getCount() == 0){
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getSettings();
//        }finally{
//            cursor.close();
//        }
//
//    }
//
//    public File getPhotoFile(Activity activity){
//        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//
//        if(externalFilesDir == null){
//            return null;
//        }
//
//        return new File(externalFilesDir, activity.getPhotoFilename());
//    }
//
//    public void updateActivity(Activity activity){
//        String uuidString = activity.getId().toString();
//        ContentValues values = getContentValues(activity);
//
//        mDatabase.update(ActivityDbSchema.ActivityTable.NAME, values, ActivityDbSchema.ActivityTable.Cols.UUID + " = ?", new String[] {uuidString});
//    }

    public void addActivity(Activity a){
//        ContentValues values = getContentValues(a);
//        mDatabase.insert(ActivityDbSchema.ActivityTable.NAME, null, values);
    }

//    private static ContentValues getContentValues(Activity activity){
//        ContentValues values = new ContentValues();
//        values.put(ActivityDbSchema.ActivityTable.Cols.UUID, activity.getId().toString());
//        values.put(ActivityDbSchema.ActivityTable.Cols.TITLE, activity.getTitle());
//        values.put(ActivityDbSchema.ActivityTable.Cols.LOCATION, activity.getLocation());
//        values.put(ActivityDbSchema.ActivityTable.Cols.DATE, activity.getDate().getTime());
//
//        return values;
//    }

//    private ActivityCursorWrapper queryActivities(String whereClause, String[] whereArgs) {
//        Cursor cursor = mDatabase.query(
//                ActivityDbSchema.ActivityTable.NAME,
//                null, //Columns - null selects all columns
//                whereClause,
//                whereArgs,
//                null, //group by
//                null, // having
//                null // order by
//        );
//        return new ActivityCursorWrapper(cursor);
//    }
}
