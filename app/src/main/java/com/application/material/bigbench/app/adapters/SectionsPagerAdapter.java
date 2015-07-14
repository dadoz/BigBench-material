package com.application.material.bigbench.app.adapters;

/**
 * Created by davide on 13/07/15.
 */

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.application.material.bigbench.app.R;
import com.application.material.bigbench.app.fragments.MapFragment;
import com.application.material.bigbench.app.models.Bench;
import com.application.material.bigbench.app.utils.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter implements OnMapReadyCallback, ViewPager.OnPageChangeListener {
    private final Activity mActivityRef;
    private final Gson mGson;
    private ArrayList<Bench> mBenchList = new ArrayList<Bench>();

    private static final String EMPTY_BENCH_NAME = "no name";
    private static final String TAG = "SectionsPagerAdapter";

    public SectionsPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        mActivityRef = activity;
        mGson = new Gson();
        onInitData();
    }

    private void onInitData() {
        String jsonData = Utils.getJsonData(mActivityRef.getAssets(), "data.json");
        Type listType = new TypeToken<ArrayList<Bench>>() {}.getType();
        mBenchList = mGson.fromJson(jsonData, listType);
    }

    private int getBenchListSize() {
        return mBenchList != null ? mBenchList.size() : 0;
    }

    @Override
    public Fragment getItem(int position) {
        SupportMapFragment mapFragment = MapFragment.newInstance(position + 1);
        try {
            mapFragment.getMapAsync(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapFragment;
    }

    @Override
    public int getCount() {
        return getBenchListSize();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        boolean hasBenchTitle = mBenchList != null &&
                mBenchList.size() > position &&
                mBenchList.get(position) != null;
        return hasBenchTitle ? mBenchList.get(position).getName() : EMPTY_BENCH_NAME;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng baroloLatLng = new LatLng(44.6, 7.93);
        googleMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(baroloLatLng, 10));
        googleMap.addMarker(new MarkerOptions()
                .position(baroloLatLng)
                .title("Barolo"));
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
    }

    @Override
    public void onPageSelected(int position) {
        try {
            switch (position) {
                case 0 :
                    setActionbarColorCustom(R.color.material_red_400, R.color.material_red_600);
                    break;
                case 1 :
                    setActionbarColorCustom(R.color.material_yellow_400, R.color.material_yellow_600);
                    break;
                case 2 :
                    setActionbarColorCustom(R.color.material_green_400, R.color.material_green_600);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setActionbarColorCustom(int lightResId, int darkResId) {
        int lightColor = mActivityRef.getResources().getColor(lightResId);
        int darkColor = mActivityRef.getResources().getColor(darkResId);
        ((AppCompatActivity) mActivityRef).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(lightColor));
        mActivityRef.findViewById(R.id.tabLayoutId).setBackgroundColor(lightColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = mActivityRef.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(darkColor);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}