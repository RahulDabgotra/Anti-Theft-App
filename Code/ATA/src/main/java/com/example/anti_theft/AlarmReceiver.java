package com.example.anti_theft;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver implements LocationListener {
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 60000;
    private static int NOTIFICATION_ID = 1;
    boolean canGetLocation = false;
    GPSTracker gps;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    double lat;
    double latitude;
    Location location = null;
    protected LocationManager locationManager;
    double log;
    double longitude;
    private Context mContext;
    SmsManager sm;

    public void onLocationChanged(Location paramLocation) {
    }

    public void onProviderDisabled(String paramString) {
    }

    public void onProviderEnabled(String paramString) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        this.gps = new GPSTracker(paramContext);
        this.lat = this.gps.latitude;
        this.log = this.gps.longitude;
        this.mContext = paramContext;
        Log.d("Latitude", String.valueOf(this.lat) + " ");
        Log.d("Longitude", String.valueOf(this.log) + " ");
        Bundle localBundle = paramIntent.getExtras();
        String str1 = localBundle.getString("title");
        String str2 = localBundle.getString("note");
        String str3 = localBundle.getString("pno");
        this.sm = SmsManager.getDefault();
        Log.d("Messageeeeeeeeeeeeeee", "Sendingggggggggggggg");
        this.sm.sendTextMessage(str3, null, String.valueOf(str1) + " " + str2, null, null);
        Log.d("Messageeeeeeeeeeeeeee", "Sendddddddddddddddddddddddd");
        Notification localNotification = new Notification(R.drawable.ic_launcher, "Combi Note", System.currentTimeMillis());
        localNotification.setLatestEventInfo(paramContext, "", "", PendingIntent.getActivity(paramContext, NOTIFICATION_ID, new Intent(paramContext, CompareIMSI.class), 0));
        localNotification.flags = 4;
        localNotification.defaults |= 1;
        int i = NOTIFICATION_ID;
        NOTIFICATION_ID = i + 1;
        ((NotificationManager) paramContext.getSystemService("notification")).notify(i, localNotification);
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {
    }
}
