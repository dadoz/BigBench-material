package com.application.material.bigbench.app;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.application.material.bigbench.app.adapters.SettingsAdapter;
import com.application.material.bigbench.app.models.Setting;

import java.util.ArrayList;

/**
 * Created by davide on 15/07/15.
 */
public class SettingsActivity extends AppCompatActivity {
    @Bind(R.id.settingListviewId)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        ButterKnife.bind(this);

        onInitView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return true;
    }

    private void onInitView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.settingsToolbarId);
        toolbar.setTitle(R.string.app_settings_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Setting> settingList = new ArrayList<Setting>();
        settingList.add(new Setting("title1", "description 1"));
        mListView.setAdapter(new SettingsAdapter(this, R.layout.setting_item, settingList));
    }
}
