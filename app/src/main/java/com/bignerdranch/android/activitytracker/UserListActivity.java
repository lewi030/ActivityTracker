package com.bignerdranch.android.activitytracker;

import android.support.v4.app.Fragment;

/**
 * Created by Nick030 on 5/10/2017.
 */

public class UserListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new ActivityListFragment();
    }
}
