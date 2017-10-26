package com.bignerdranch.android.activitytracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

import static com.bignerdranch.android.activitytracker.ActivityFragment.newInstance;

/**
 * Created by Nick030 on 14/10/2017.
 */

public class ActivityPagerActivity extends FragmentActivity {
    private static final String EXTRA_ACTIVITY_ID = "com.bignerdranch.android.criminalIntent.crime_id";

    private ViewPager mViewPager;
    private List<Activity> mActivities;

    public static Intent newIntent(Context packageContext, UUID activityId){
        Intent intent = new Intent(packageContext, ActivityPagerActivity.class);
        intent.putExtra(EXTRA_ACTIVITY_ID, activityId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_pager);

        UUID activityId = (UUID) getIntent().getSerializableExtra(EXTRA_ACTIVITY_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_activity_pager_view_pager);

        mActivities = ActivityLab.get(this).getActivities();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager){
            @Override
            public Fragment getItem(int position){
                Activity activity = mActivities.get(position);
                return ActivityFragment.newInstance(activity.getId());
            }

            @Override
                    public int getCount(){
                return mActivities.size();
            }
        });

        for (int i = 0; i <mActivities.size(); i++){
            if (mActivities.get(i).getId().equals(activityId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
