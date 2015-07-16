package com.application.material.bigbench.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.application.material.bigbench.app.R;
import com.application.material.bigbench.app.models.Setting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davide on 15/07/15.
 */
public class SettingsAdapter extends ArrayAdapter<Setting>{

    private final ArrayList<Setting> mSettingList;

    public SettingsAdapter(Context context, int resource, ArrayList<Setting> list) {
        super(context, resource, list);
        mSettingList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.setting_item, null);
        }

        TextView settingTitle = (TextView) convertView.findViewById(R.id.settingTitleTextId);
        settingTitle.setText("title new");
        TextView settingDescription = (TextView) convertView.findViewById(R.id.settingDescriptionTextId);
        settingDescription.setText("description new");

        return convertView;
    }
}
