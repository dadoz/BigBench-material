package com.application.material.bigbench.app.utils;

import android.content.res.AssetManager;
import com.google.android.gms.wearable.Asset;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by davide on 13/07/15.
 */
public class Utils {

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

}
