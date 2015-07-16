package com.application.material.bigbench.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import com.application.material.bigbench.app.R;
import com.google.android.gms.wearable.Asset;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by davide on 13/07/15.
 */
public class Utils {

    private static int[] colorByPosition;

    public static String getJsonData(AssetManager assets, String fileName) {
        String data = null;
        try {
            InputStream is = assets.open(fileName);
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            data = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static int[] getColorArrayByPosition(int position) {
        int[] values = new int[3];
        switch (position) {
            case 0:
                values[0] = R.color.material_red_400;
                values[1] = R.color.material_red_600;
                values[2] = R.color.material_red_200;
                break;
            case 1:
                values[0] = R.color.material_deep_purple_300;
                values[1] = R.color.material_deep_purple_400;
                values[2] = R.color.material_deep_purple_200;
                break;
            case 2:
                values[0] = R.color.material_yellow_400;
                values[1] = R.color.material_yellow_600;
                values[2] = R.color.material_yellow_200;
                break;
            case 3:
                values[0] = R.color.material_light_blue_500;
                values[1] = R.color.material_light_blue_600;
                values[2] = R.color.material_light_blue_200;
                break;
            case 4:
                values[0] = R.color.material_gold_500;
                values[1] = R.color.material_gold_600;
                values[2] = R.color.material_gold_300;
                break;
            case 5:
                values[0] = R.color.material_pink_400;
                values[1] = R.color.material_pink_500;
                values[2] = R.color.material_pink_200;
                break;
            case 6:
                values[0] = R.color.material_grey_50;
                values[1] = R.color.material_grey_300;
                values[2] = R.color.material_grey_200;
                break;
            case 7:
                values[0] = R.color.material_amber_700;
                values[1] = R.color.material_amber_800;
                values[2] = R.color.material_amber_200;
                break;
            default:
                values[0] = R.color.material_red_400;
                values[1] = R.color.material_red_600;
                values[2] = R.color.material_red_200;
        }
        return values;
    }



}
