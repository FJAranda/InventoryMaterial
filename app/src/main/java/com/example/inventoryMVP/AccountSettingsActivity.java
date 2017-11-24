package com.example.inventoryMVP;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class AccountSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
