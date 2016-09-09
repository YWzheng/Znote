package com.ywzheng.znote.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

import com.ywzheng.znote.R;

/**
 * Created by yongwei on 2016/9/9.
 */

public class MyPreferenceFragment extends PreferenceFragment {

    private SwitchPreference imagePref;
    private CheckBoxPreference darkPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);


        final SharedPreferences.Editor my_prefrence = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();

        imagePref = (SwitchPreference) findPreference("imagequality");
        imagePref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                String quality;

                SwitchPreference switchPreference = (SwitchPreference) preference;

                if (!switchPreference.isChecked()) {
                    quality = "w1000";
                } else {
                    quality = "w780";
                }


                my_prefrence.putString("image_quality", quality);
                my_prefrence.apply();

                return true;
            }
        });


        darkPref = (CheckBoxPreference) findPreference("dark");
        darkPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {

                recreateActivity();

                return true;
            }
        });

        Preference liscence = (Preference) findPreference("license");
        liscence.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
//                startActivity(new Intent(getActivity(), License.class));
                return true;
            }
        });


        Preference share = (Preference) findPreference("Share");
        share.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                String app_share_details = "";
                if (!(app_share_details.equals(null))) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    myIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome movie app.\n" + "*filmy*\n" + app_share_details);
                    startActivity(Intent.createChooser(myIntent, "Share with"));
                }
                return true;
            }
        });


        Preference about = (Preference) findPreference("About");
        about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
//                startActivity(new Intent(getActivity(), AboutActivity.class));
                return true;
            }
        });

    }

    private void recreateActivity() {
        getActivity().recreate();
    }

}
