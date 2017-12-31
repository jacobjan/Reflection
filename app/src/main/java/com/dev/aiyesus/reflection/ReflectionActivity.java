package com.dev.aiyesus.reflection;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class ReflectionActivity extends Activity {

    EditText longlat;
    Location mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection);
        mResults = (TextView) findViewById(R.id.results);
        mResults.setTypeface(null, Typeface.BOLD | Typeface.ITALIC);
        // mResults.setScrollbarFadingEnabled(false);

        // This allows us to later extend the text buffer.
        mResults.setMovementMethod(new ScrollingMovementMethod());
        mResults.setText(mResults.getText(), TextView.BufferType.EDITABLE);
        /*String perms[] = new String[1];
        perms[0] = Manifest.permission.ACCESS_FINE_LOCATION;
        ActivityCompat.requestPermissions(getApplicationContext(), perms, 0);
*/
        longlat = (EditText) findViewById(R.id.longlat);
        // Watch for button clicks.
        Button b = (Button) findViewById(R.id.get);
        b.setOnClickListener(mGetListener);

        b = (Button) findViewById(R.id.showloc);
        b.setOnClickListener(mShowMap);

        b = (Button) findViewById(R.id.clear);
        b.setOnClickListener(mClearTextView);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("ReflectionActivity", "---keycode.HOME_KEY is pressed, onPause ?");
        if (isApplicationSentToBackground(this)) {
            Log.i("ReflectionActivity", "---keycode.HOME_KEY is pressed, not handled by frame work ?");
            //Snackbar snackbar = Snackbar.make( , "Welcome to AndroidHive", Snackbar.LENGTH_LONG);
            //snackbar.show();
            //snackbar.set
        }
    }

    public boolean isApplicationSentToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        Log.i("ReflectionActivity", "---isApplicationSentToBackground tasks ?" + tasks.size());
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        // You can use the requestCode to select between multiple child
        // activities you may have started.  Here there is only one thing
        // we launch.
        if (requestCode == GET_CODE) {

            // We will be adding to our text.
            Editable text = (Editable) mResults.getText();

            // This is a standard resultCode that is sent back if the
            // activity doesn't supply an explicit result.  It will also
            // be returned if the activity failed to launch.
            if (resultCode == RESULT_CANCELED) {
                text.append("(cancelled)");

                // Our protocol with the sending activity is that it will send
                // text in 'data' as its result.
            } else {
                text.append("(resultCode ");
                text.append(Integer.toString(resultCode));
                text.append(") ");
                if (data != null) {
                    text.append(data.getAction());
                }
            }
            text.append("\n");
        }
    }

    // Definition of the one requestCode we use for receiving resuls.
    static final private int GET_CODE = 0;

    private View.OnClickListener mGetListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Start the activity whose result we want to retrieve.  The
            // result will come back with request code GET_CODE.
            Intent intent = new Intent(ReflectionActivity.this, SendResult.class);
            Log.i("ReflectionActivity", "startA F R from reflection");
            startActivityForResult(intent, GET_CODE);
        }
    };

    private View.OnClickListener mShowMap = new View.OnClickListener() {
        public void onClick(View v) {
            String latLongStr = (String) longlat.getText().toString();
            String loc[] = latLongStr.split(",");

            float lg, lat;
            if (loc.length < 2) {
                //  No valid input, use current location: Get current location, Turn GPS on,
                //  get location manager, build location listner, LocMgr.requestLocationUpdate
                float[] latlg = getCurrentLocation();
                lat = latlg[0];
                lg = latlg[1];
            } else {
                lat = Float.parseFloat(loc[0]);
                lg = Float.parseFloat(loc[1]);
            }
            Log.i("ReflectionActivity", "Lat Long entered :" + latLongStr);
            String zoomStr = "&z=12";
            String label = "Buneill @ cream";
            String uriBegin = "geo:"+latLongStr+zoomStr;
            String query = latLongStr+"(" + latLongStr + ")";
            String encodedQuery = Uri.encode( query  );
            String uriString = uriBegin + "?q=" + query;
            Uri uri = Uri.parse( uriString );
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
            startActivity( intent );
 /*           String uri = String.format(Locale.ENGLISH, "geo:%f,%f(%s)", lat, lg, longlatStr);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
*/        }
    };

    public float[] getCurrentLocation() {
        float[] lglat = new float[2];
        lglat[0] = -122.33f;
        lglat[1] = 47.88f;

        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();
        // location update every 3 sec or 10 meters distance difference
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return lglat;
        }
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, mlocListener);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lglat[0] = (float)mLocation.getLongitude();
        lglat[1] = (float)mLocation.getLatitude();
        Log.i("ReflectionActivity", "**** CURR loc info :" + mLocation.toString());
        return lglat;
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            mLocation = loc;
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {
        }
    }

        private View.OnClickListener mClearTextView = new View.OnClickListener() {
        public void onClick(View v) {
            mResults.setText("");
        }
    };

    private TextView mResults;
}
