package com.application.material.bigbench.app.fragments;

/**
 * Created by davide on 13/07/15.
 */

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.application.material.bigbench.app.R;
import com.application.material.bigbench.app.buttonExtension.FabCustom;
import com.application.material.bigbench.app.utils.Utils;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.HashSet;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class BenchMapFragment extends SupportMapFragment implements View.OnClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "PlaceholderFragment";
    private View mMapView;
    private int mSectionNumber;
    private String CHECK_VISITED_ARRAY = "CHECK_VISITED_ARRAY";
    private String BIG_BENCH_SHAREDPREF = "BIG_BENCH_SHAREDPREF";
    @Bind(R.id.mapLayoutOverId) private View mMapLayoutOver;
    @Bind(R.id.checkVisitedButtonId) private FabCustom mCheckVisitedButton;
    @Bind(R.id.uncheckVisitedBenchLayoutId) private FabCustom mUncheckVisitedBenchLayout;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BenchMapFragment newInstance(int sectionNumber) {
        BenchMapFragment fragment = new BenchMapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     */
    public BenchMapFragment() {
        super();
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMapView = super.onCreateView(inflater, container, savedInstanceState);
        View child = getLayoutInflater(savedInstanceState).inflate(R.layout.map_layout, null);
        ((ViewGroup) mMapView).addView(child);
        ButterKnife.bind(this, mMapView);
//        mMapLayoutOver = mMapView.findViewById(R.id.mapLayoutOverId);

        mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        onInitView();
        return mMapView;
    }

    /**
     *
     */
    private void onInitView() {
        mCheckVisitedButton.setOnClickListener(this);
        if (isCheckVisitedSharedPref(mSectionNumber)) {
            setCheckVisitedView(true);
        }
    }

    /**
     *
     */
    private void setCheckVisitedView(final boolean visible) {
        //set background color to frame
        int[] colorArray = Utils.getColorArrayByPosition(mSectionNumber - 1);
        mMapLayoutOver.setBackgroundColor(visible ? getResources().getColor(colorArray[2]) : Color.TRANSPARENT);
        mUncheckVisitedBenchLayout.setOnClickListener(visible ? this : null);
        if (visible) {
            mCheckVisitedButton.hide(true);
        } else {
            mCheckVisitedButton.show(true);
        }
    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkVisitedButtonId:
                Toast.makeText(getActivity(), "checking this bench as visited!", Toast.LENGTH_SHORT).show();
                //HIDE map
                //save on sharedPref this bench has been already visisted
                setCheckVisitedSharedPref(mSectionNumber);
                setCheckVisitedView(true);
                break;
            case R.id.uncheckVisitedBenchLayoutId:
                unsetCheckVisitedSharedPref(mSectionNumber);
                setCheckVisitedView(false);
                break;
        }
    }

    /**
     *
     * @param position
     */
    private void setCheckVisitedSharedPref(int position) {
        SharedPreferences sharedPref = getActivity().getSharedPreferences(BIG_BENCH_SHAREDPREF, 0);
        Set<String> set = sharedPref.getStringSet(CHECK_VISITED_ARRAY, null);
        if (set == null) {
            set = new HashSet<String>();
        }

        set.add(Integer.toString(position));
        sharedPref.edit().putStringSet(CHECK_VISITED_ARRAY, set).commit();
    }

    /**
     *
     * @param position
     */
    private void unsetCheckVisitedSharedPref(int position) {
        SharedPreferences sharedPref = getActivity().getSharedPreferences(BIG_BENCH_SHAREDPREF, 0);
        Set<String> set = sharedPref.getStringSet(CHECK_VISITED_ARRAY, null);
        set.remove(Integer.toString(position));
        sharedPref.edit().putStringSet(CHECK_VISITED_ARRAY, set).commit();
    }

    /**
     *
     * @param position
     * @return
     */
    private boolean isCheckVisitedSharedPref(int position) {
        SharedPreferences sharedPref = getActivity().getSharedPreferences(BIG_BENCH_SHAREDPREF, 0);
        Set<String> set = sharedPref.getStringSet(CHECK_VISITED_ARRAY, null);

        return set != null &&
                set.contains(Integer.toString(position));
    }

    /**
     *
     * @param colorRes
     */
    public void setCheckVisitedBenchButtonColor(int colorRes) {
        mCheckVisitedButton.setBackgroundTintList(ColorStateList
                .valueOf(getResources().getColor(colorRes)));
    }
}