package com.bignerdranch.android.activitytracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.List;
import java.util.UUID;

/**
 * Created by Nick030 on 14/10/2017.
 */

public class SettingsPagerActivity extends FragmentActivity {
    private static final String EXTRA_SETTINGS_ID = "com.bignerdranch.android.activitytracker.settings_id";

   // private ViewPager mViewPager;
    private Activity mSetting;

    public static Intent newIntent(Context packageContext, UUID settingsId){
        Intent intent = new Intent(packageContext, SettingsPagerActivity.class);
        Log.d("my error", "i am here6");
        intent.putExtra(EXTRA_SETTINGS_ID, settingsId);
        Log.d("my error7", settingsId.toString());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("my error10", "I'm still here");
//        setContentView(R.layout.settings_activity_pager);

//        UUID activityId = (UUID) getIntent().getSerializableExtra(EXTRA_SETTINGS_ID);

//        mViewPager = (ViewPager) findViewById(R.id.activity_activity_pager_view_pager);
//
//        mSetting = SettingsPage.get(this).getSetting(activityId);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager){
//            @Override
//            public Fragment getItem(int position){
//                Activity activity = mActivities.get(position);
//                return ActivityFragment.newInstance(activity.getId());
//            }
//
//            @Override
//                    public int getCount(){
//                return mActivities.size();
//            }
//        });
//
//        for (int i = 0; i <mActivities.size(); i++){
//            if (mActivities.get(i).getId().equals(activityId)){
//                mViewPager.setCurrentItem(i);
//                break;
//            }
//        }
    }
}
