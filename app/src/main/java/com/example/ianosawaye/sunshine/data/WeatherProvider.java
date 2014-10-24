package com.example.ianosawaye.sunshine.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.example.ianosawaye.sunshine.data.WeatherContract.WeatherEntry;
import com.example.ianosawaye.sunshine.data.WeatherContract.LocationEntry;

/**
 * Created by ianosawaye on 14-10-23.
 */
public class WeatherProvider extends ContentProvider {

    private static final int WEATHER = 100;
    private static final int WEATHER_WITH_LOCATION = 101;
    private static final int WEATHER_WITH_LOCATION_AND_DATE = 102;
    private static final int LOCATION = 300;
    private static final int LOCATION_ID = 301;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    private static UriMatcher buildUriMatcher()
    {
        UriMatcher Matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = WeatherContract.CONTENT_AUTHORITY;
        Matcher.addURI(authority, WeatherEntry.CONTENT_URI.toString(),WEATHER);
        Matcher.addURI(authority, WeatherEntry.CONTENT_URI.toString()+"/*",WEATHER_WITH_LOCATION);
        Matcher.addURI(authority,WeatherEntry.CONTENT_URI.toString()+"/*/*",WEATHER_WITH_LOCATION_AND_DATE);
        Matcher.addURI(authority,LocationEntry.CONTENT_URI.toString(),LOCATION);
        Matcher.addURI(authority,LocationEntry.CONTENT_URI.toString()+"/#",LOCATION_ID);

        return Matcher;
    }
}
