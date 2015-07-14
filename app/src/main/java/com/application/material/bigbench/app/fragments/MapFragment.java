package com.application.material.bigbench.app.fragments;

/**
 * Created by davide on 13/07/15.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.application.material.bigbench.app.R;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class MapFragment extends SupportMapFragment implements View.OnClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "PlaceholderFragment";
    private View mMapView;
    private FloatingActionButton mCheckVisitedButton;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MapFragment newInstance(int sectionNumber) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MapFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMapView = super.onCreateView(inflater, container, savedInstanceState);

        View child = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_main, null);
        ((ViewGroup) mMapView).addView(child);

        onInitView();
        return mMapView;
    }

    private void onInitView() {
        mCheckVisitedButton = (FloatingActionButton) mMapView.findViewById(R.id.checkVisitedButtonId);
        mCheckVisitedButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkVisitedButtonId:
                Toast.makeText(getActivity(), "checking this bench as visited!", Toast.LENGTH_SHORT).show();
                //HIDE map
                //set background color to frame
                //save on sharedPref this bench has been already visisted
                break;
        }
    }
}