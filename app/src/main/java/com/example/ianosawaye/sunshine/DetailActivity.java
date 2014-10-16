package com.example.ianosawaye.sunshine;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            PlaceholderFragment details = new PlaceholderFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, details)
                    .commit();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings2) {
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            String forecastData = getArguments().getString(Intent.EXTRA_TEXT);
            TextView Date = (TextView) rootView.findViewById(R.id.date);
            TextView High = (TextView) rootView.findViewById(R.id.high);
            TextView Low = (TextView) rootView.findViewById(R.id.low);
            TextView Condition = (TextView) rootView.findViewById(R.id.condition);

            String[] parts = forecastData.split("-");
            Date.setTextSize(15);
            Condition.setTextSize(15);
            Date.setText(parts[0]);
            Condition.setText(parts[1]);

            String[] highLow = parts[2].split("/");
            High.setTextSize(25);
            Low.setTextSize(25);
            High.setText(highLow[0]);
            Low.setText(highLow[1]);
            return rootView;
        }
    }
}
