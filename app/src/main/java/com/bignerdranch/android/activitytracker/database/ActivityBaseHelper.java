package com.bignerdranch.android.activitytracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.ActivityTable;
import com.bignerdranch.android.activitytracker.database.ActivityDbSchema.UserInfoTable;
/**
 * Created by Nick030 on 12/10/2017.
 */

public class ActivityBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "activityBase.db";

    public ActivityBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Code used to create the table to store information.
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " +  ActivityTable.NAME + "(" + " _id integer primary key autoincrement, " + ActivityTable.Cols.UUID + ", " + ActivityTable.Cols.TITLE + ", " + ActivityTable.Cols.LOCATION + ", " + ActivityTable.Cols.DATE + ", " + ActivityTable.Cols.COMMENT + ", " + ActivityTable.Cols.DURATION + ")");
        db.execSQL("create table " +  UserInfoTable.NAME + "(" + " _id integer primary key autoincrement, " + UserInfoTable.Cols.UUID + ", " + UserInfoTable.Cols.NAME + ", " + UserInfoTable.Cols.EMAIL + ", " + UserInfoTable.Cols.GENDER + ", " + UserInfoTable.Cols.COMMENT + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
