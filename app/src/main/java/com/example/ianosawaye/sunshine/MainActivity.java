package com.example.ianosawaye.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.example.ianosawaye.sunshine.data.WeatherContract;
import com.example.ianosawaye.sunshine.sync.SunshineSyncAdapter;

import java.util.Date;


public class MainActivity extends ActionBarActivity implements Callback{

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.weather_detail_container)!=null)
        {
            // The detail container view will be present only in the large-screen layouts
            // (res/layout-sw600dp). If this view is present, then the activity should be
            // in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            if (savedInstanceState == null) {
                Bundle args = new Bundle();
                args.putString("DATE", WeatherContract.getDbDateString(new Date()));
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(args);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.weather_detail_container, detailFragment)
                        .commit();
            }
        }
        else
        {
            mTwoPane = false;
        }

        ForecastFragment forecastFragment = (ForecastFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_forecast);
        forecastFragment.setUseTodayLayout(!mTwoPane);
        SunshineSyncAdapter.initializeSyncAdapter(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onItemSelected(String date) {

        if(mTwoPane)
        {

            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle args = new Bundle();
            args.putString("DATE",date);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.weather_detail_container, detailFragment)
                        .commit();
         }
        else
        {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("DATE", date);
            startActivity(intent);
        }

    }
}


