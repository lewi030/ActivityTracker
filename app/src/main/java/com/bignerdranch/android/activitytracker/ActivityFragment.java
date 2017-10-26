package com.bignerdranch.android.activitytracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;
import java.util.UUID;

/**
 * Created by Nick030 on 4/10/2017.
 *
 * CrimeFragment.java
 *
 * controller
 *
 * Activity fragment is a controller that interacts with model and view objects. Its job is to present the details of a specific crime and update those details as the user changes them.
 *
 */

public class ActivityFragment extends Fragment {

    private static final String ARG_ACTIVITY_ID = "activity_id";

    private Activity mActivity;
    private EditText mTitleField;
    private EditText mCommentField;
    private EditText mDurationField;
    private EditText mLocationField;
    private Button mDateButton;

    private ImageButton mPhotoButton;
    private ImageView mPhotoView;
    private File mPhotoFile;
    private boolean mSubtitleVisible;

    private static final int REQUEST_PHOTO= 0;

//   Spinner activityType = (Spinner) findViewById(R.id.activityType);
//    // Create an ArrayAdapter using the string array and a default spinner layout
//   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//        R.array.activityType, android.R.layout.simple_spinner_item);
//    // Specify the layout to use when the list of choices appears
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    // Apply the adapter to the spinner
//    activityType.setAdapter(adapter);

    public static ActivityFragment newInstance(UUID activityId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ACTIVITY_ID, activityId);

        ActivityFragment fragment = new ActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID activityId = (UUID) getArguments().getSerializable(ARG_ACTIVITY_ID);
        mActivity = ActivityLab.get(getActivity()).getActivity(activityId); //31% two get activities
        mPhotoFile = ActivityLab.get(getActivity()).getPhotoFile(mActivity);

    }

    @Override
    public void onPause(){
        super.onPause();
        ActivityLab.get(getActivity()).updateActivity(mActivity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_activitydetails, container, false);

        mTitleField = (EditText) v.findViewById(R.id.activity_title);
        mTitleField.setText(mActivity.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                //no need to do anything
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                mActivity.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no need to do anything
            }
        });

        mLocationField = (EditText) v.findViewById(R.id.activity_location);
        mLocationField.setText(mActivity.getLocation());
        mLocationField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                //no need to do anything
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                mActivity.setLocation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no need to do anything
            }
        });

        mCommentField = (EditText) v.findViewById(R.id.activity_comment);
        mCommentField.setText(mActivity.getActivityComment());
        mCommentField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                //no need to do anything
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                mActivity.setLocation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no need to do anything
            }
        });

        mDurationField = (EditText) v.findViewById(R.id.activity_duration);
        mDurationField.setText(mActivity.getDuration());
        mDurationField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                //no need to do anything
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                mActivity.setLocation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no need to do anything
            }
        });

        mDateButton = (Button)v.findViewById(R.id.activity_date);
        mDateButton.setText(mActivity.getDate().toString());
        mDateButton.setEnabled(false);

        mPhotoButton = (ImageButton) v.findViewById(R.id.activity_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        boolean canTakePhoto = mPhotoFile != null; // && captureImage.resolveActivity(packageManager) != null; //This bit of code may refer to criminal intents is activity solved checkbox
        mPhotoButton.setEnabled(canTakePhoto);

        if(canTakePhoto){
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        mPhotoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mPhotoView = (ImageView) v.findViewById(R.id.activity_photo);
       // updatePhotoView();


        if(ARG_ACTIVITY_ID != null){
           return v;
        }else {
            return v;
        }
    }



//    private void updatePhotoView(){
//        if (mPhotoFile == null || !mPhotoFile.exists()){
 //           mPhotoView.setImageDrawable(null);
 //       }else{
  //          Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
 //           mPhotoView.setImageBitmap(bitmap);
 //       }
 //   }
}
