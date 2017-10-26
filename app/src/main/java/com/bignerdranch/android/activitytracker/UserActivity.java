package com.bignerdranch.android.activitytracker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import java.util.UUID;

/**
 *
 * CrimeActivity.java
 *
 */

public class UserActivity extends SingleFragmentActivity {

    private static final String EXTRA_ACTIVITY_ID = "com.bignerdranch.android.activitytracker.activity_id";

    public static Intent newIntent (Context packageContext, UUID activityId){
        Intent intent = new Intent(packageContext, UserActivity.class);
        intent.putExtra(EXTRA_ACTIVITY_ID, activityId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID activityId = (UUID) getIntent().getSerializableExtra(EXTRA_ACTIVITY_ID);
        return ActivityFragment.newInstance(activityId);
    }
}
