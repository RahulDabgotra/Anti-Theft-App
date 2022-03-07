package com.example.anti_theft;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class GPSTracker implements LocationListener {
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 60000;
    boolean canGetLocation = false;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    double latitude;
    Location location;
    protected LocationManager locationManager;
    double longitude;
    private final Context mContext;

    public GPSTracker(Context paramContext) {
        this.mContext = paramContext;
        getLocation();
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public Location getLocation() {
        try {
            this.locationManager = (LocationManager) this.mContext.getSystemService("LOCATION_SERVICE");
            this.isGPSEnabled = this.locationManager.isProviderEnabled("gps");
            this.isNetworkEnabled = this.locationManager.isProviderEnabled("network");
            if (this.isGPSEnabled || this.isNetworkEnabled) {
                this.canGetLocation = true;
                if (this.isNetworkEnabled) {
                    this.locationManager.requestLocationUpdates("network", MIN_TIME_BW_UPDATES, 10.0f, this);
                    Log.d("Network", "Network");
                    if (this.locationManager != null) {
                        this.location = this.locationManager.getLastKnownLocation("network");
                        if (this.location != null) {
                            this.latitude = this.location.getLatitude();
                            this.longitude = this.location.getLongitude();
                            Log.d("NNNNNNNNNNNNNNNN", String.valueOf(this.latitude) + "^^^^^^^^^^^^^^" + this.longitude);
                        }
                    }
                }
                if (this.isGPSEnabled && this.location == null) {
                    this.locationManager.requestLocationUpdates("gps", MIN_TIME_BW_UPDATES, 10.0f, this);
                    Log.d("GPS Enabled", "GPS Enabled");
                    if (this.locationManager != null) {
                        this.location = this.locationManager.getLastKnownLocation("gps");
                        if (this.location != null) {
                            this.latitude = this.location.getLatitude();
                            this.longitude = this.location.getLongitude();
                            Log.d("ggggggggggggggggggggg", String.valueOf(this.latitude) + "^^^^^^^^^^^^^^" + this.longitude);
                        }
                    }
                }
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return this.location;
    }

    public void onLocationChanged(Location paramLocation) {
    }

    public void onProviderDisabled(String paramString) {
    }

    public void onProviderEnabled(String paramString) {
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {
    }

    public void showSettingsAlert() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
        localBuilder.setTitle("GPS is settings");
        localBuilder.setMessage("GPS is not enabled. Do you want to go to settings menu?");
        localBuilder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            /* class com.example.anti_theft.GPSTracker.AnonymousClass1 */

            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                GPSTracker.this.mContext.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        localBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            /* class com.example.anti_theft.GPSTracker.AnonymousClass2 */

            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface.cancel();
            }
        });
        localBuilder.show();
    }

    public void stopUsingGPS() {
        if (this.locationManager != null) {
            this.locationManager.removeUpdates(this);
        }
    }
}
