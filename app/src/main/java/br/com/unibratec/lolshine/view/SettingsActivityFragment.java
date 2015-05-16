package br.com.unibratec.lolshine.view;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import br.com.unibratec.lolshine.R;

public class SettingsActivityFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

    public SettingsActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        bindPreferenceSummary(findPreference(getString(R.string.pref_region_key)));
    }

    private void bindPreferenceSummary(Preference preference){
        preference.setOnPreferenceChangeListener(this);
        Object value = PreferenceManager.getDefaultSharedPreferences(getActivity()).
                getString(preference.getKey(), "");
        onPreferenceChange(preference, value);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String stringValue = newValue.toString();

        if (preference instanceof ListPreference){
            ListPreference listPreference =
                    (ListPreference)preference;
            int index = listPreference.findIndexOfValue(stringValue);
            if (index >= 0){
                preference.setSummary(
                        listPreference.getEntries()[index]);
            }
        } else {
            preference.setSummary(stringValue);
        }
        return true;
    }
}
