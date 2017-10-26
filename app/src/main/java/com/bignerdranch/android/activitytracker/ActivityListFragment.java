package com.bignerdranch.android.activitytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

/**
 * Created by Nick030 on 5/10/2017.
 */

public class ActivityListFragment extends Fragment {
    private RecyclerView mActivityRecyclerView;
    private ActivityAdapter mAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);

        mActivityRecyclerView = (RecyclerView) view.findViewById(R.id.activity_recycler_view);
        mActivityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.fragment_activity_list, menu);
       // inflater.inflate(R.menu.fragment_activity_list, menu);

        //show subtitle code
       // MenuItem subtitleItem = menu.findItem(R.id.menu_item_show_subtitle);
       // if(mSubtitleVisible){
       //     subtitleItem.setTitle(R.string.hide_subtitle);
        //}else{
       //     subtitleItem.setTitle(R.string.show_subtitle);
       // }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item_new_activity:
                Activity activity = new Activity();
                ActivityLab.get(getActivity()).addActivity(activity);
                Intent intent = ActivityPagerActivity.newIntent(getActivity(), activity.getId());
                startActivity(intent);
                return true;

            //code for opening settings page
            case R.id.menu_item_settings:
                Activity settingsActivity = new Activity();
                SettingsPage.get(getActivity()).addActivity(settingsActivity);
                Intent settingsintent = SettingsPagerActivity.newIntent(getActivity(), settingsActivity.getId());
                Log.d("my error", "i am here3");
                startActivity(settingsintent);
                Log.d("my error", "i am here4");
            return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle(){
        ActivityLab activityLab = ActivityLab.get(getActivity());
        int activityCount = activityLab.getActivities().size();
        String subtitle = getString(R.string.subtitle_format, activityCount);

        if(!mSubtitleVisible){
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI() {
        ActivityLab activityLab = ActivityLab.get(getActivity());
        List<Activity> activities = activityLab.getActivities();

        if (mAdapter == null){
            mAdapter = new ActivityAdapter(activities);
            mActivityRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }

        updateSubtitle();
    }

    private class ActivityHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Activity mActivity;
        private TextView mTitleTextView;
        private TextView mLocationTextView;
        private TextView mDateTextView;

        public void bindActivity(Activity activity){
            mActivity = activity;
            mTitleTextView.setText(mActivity.getTitle());
            mLocationTextView.setText(mActivity.getLocation());
            mDateTextView.setText(mActivity.getDate().toString());
            //updateUI();
        }

        public ActivityHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView)itemView.findViewById(R.id.list_item_activity_title_text_view);
            mLocationTextView = (TextView)itemView.findViewById(R.id.list_item_activity_location_text_view);
            mDateTextView = (TextView)itemView.findViewById(R.id.list_item_activity_date_text_view);
        }

        @Override
        public void onClick (View v){
            Intent intent = ActivityPagerActivity.newIntent(getActivity(), mActivity.getId());
            startActivity(intent);
        }
    }

    private class ActivityAdapter extends RecyclerView.Adapter<ActivityHolder>{
        private List<Activity> mActivities;

        public ActivityAdapter(List<Activity> activities){
            mActivities = activities;
        }

        @Override
        public ActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
            View view = layoutinflater.inflate(R.layout.list_item_activity, parent, false);
            return new ActivityHolder(view);
        }

        @Override
        public void onBindViewHolder(ActivityHolder holder, int position){
            Activity activity = mActivities.get(position);
            holder.bindActivity(activity);
        }

        @Override
        public int getItemCount(){
            return mActivities.size();
        }
    }
}
