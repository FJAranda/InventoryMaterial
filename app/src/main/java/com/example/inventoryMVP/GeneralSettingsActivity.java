package com.example.inventoryMVP;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class GeneralSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }
}
