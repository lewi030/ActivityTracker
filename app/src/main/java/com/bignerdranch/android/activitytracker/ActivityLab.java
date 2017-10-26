package com.bignerdranch.android.activitytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.bignerdranch.android.activitytracker.database.ActivityBaseHelper;
import com.bignerdranch.android.activitytracker.database.ActivityCursorWrapper;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.ActivityTable;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.UserInfoTable;

/**
 * Created by Nick030 on 5/10/2017.
 */

public class ActivityLab {
    private static ActivityLab sActivityLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ActivityLab get(Context context){
        if(sActivityLab == null){
            sActivityLab = new ActivityLab(context);
        }
        return sActivityLab;
    }

    private ActivityLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new ActivityBaseHelper(mContext).getWritableDatabase();
    }

    public List<Activity> getActivities(){
        List<Activity> activities = new ArrayList<>();

        ActivityCursorWrapper cursor = queryActivities(null, null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                activities.add(cursor.getActivity());
                cursor.moveToNext();
            }
        }finally{
            cursor.close();
        }
        return activities;
    }

    public Activity getActivity(UUID id){
        ActivityCursorWrapper cursor = queryActivities(
                ActivityTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getActivity();
        }finally{
            cursor.close();
        }

    }

    public Activity getSettings(UUID id){
        ActivityCursorWrapper cursor = queryActivities(
                UserInfoTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSettings();
        }finally{
            cursor.close();
        }

    }

    public File getPhotoFile(Activity activity){
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if(externalFilesDir == null){
            return null;
        }

        return new File(externalFilesDir, activity.getPhotoFilename());
    }

    public void updateActivity(Activity activity){
        String uuidString = activity.getId().toString();
        ContentValues values = getContentValues(activity);

        mDatabase.update(ActivityTable.NAME, values, ActivityTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    public void addActivity(Activity a){
        ContentValues values = getContentValues(a);
        mDatabase.insert(ActivityTable.NAME, null, values);
    }

    private static ContentValues getContentValues(Activity activity){
        ContentValues values = new ContentValues();
        values.put(ActivityTable.Cols.UUID, activity.getId().toString());
        values.put(ActivityTable.Cols.TITLE, activity.getTitle());
        values.put(ActivityTable.Cols.LOCATION, activity.getLocation());
        values.put(ActivityTable.Cols.DATE, activity.getDate().getTime());

        return values;
    }

    private ActivityCursorWrapper queryActivities(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                ActivityTable.NAME,
                null, //Columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null, // having
                null // order by
        );
        return new ActivityCursorWrapper(cursor);
    }

//Below is db test

//    public void updateSettings(Activity activity){
//        String uuidString = activity.getId().toString();
//        ContentValues values = getContentValues(activity);
//
//        mDatabase.update(UserInfoTable.NAME, values, UserInfoTable.Cols.UUID + " = ?", new String[] {uuidString});
//    }

//    private static ContentValues getSettingsContentValues(Activity activity){
//        ContentValues values = new ContentValues();
//        values.put(UserInfoTable.Cols.UUID, activity.getId().toString());
//       values.put(UserInfoTable.Cols.NAME, activity.getName());
//        values.put(UserInfoTable.Cols.EMAIL, activity.getEmail());
//        values.put(UserInfoTable.Cols.GENDER, activity.getGender());
//        values.put(UserInfoTable.Cols.COMMENT, activity.getComment());
//        return values;
//    }

//    private ActivityCursorWrapper querySettings(String whereClause, String[] whereArgs){
//             Cursor cursor2 = mDatabase.query(
//                     UserInfoTable.NAME,
//                     null, //Columns - null selects all columns
//                      whereClause,
//                      whereArgs,
//                     null, //group by
//                     null, // having
//                     null // order by
//               );
//       return new ActivityCursorWrapper(cursor2);
//    }
}
