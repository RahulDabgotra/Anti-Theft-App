package com.example.anti_theft;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CompareIMSI extends Service {
    Bundle bd;
    Context context;
    GPSTracker gps;
    double lat;
    double log;
    TelephonyManager operator;

    public void compareSIM() {
        RegisterData db = new RegisterData(this);
        db.open();
        String n = db.fetchNumber();
        System.out.println("......." + n);
        db.close();
        Toast.makeText(this, String.valueOf(n) + "   " + this.lat + "   " + this.log, 1).show();
        Intent localIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
        localIntent.putExtra("pno", n);
        localIntent.putExtra("title", "Your phone has detected a new SIM");
        localIntent.putExtra("note", "Your sim has changed");
        ((AlarmManager) getSystemService("alarm")).set(0, System.currentTimeMillis(), PendingIntent.getBroadcast(getApplicationContext(), 0, localIntent, 134217730));
        Toast.makeText(getApplicationContext(), "Alarm is Set", 0).show();
    }

    public String getSubscriberId() {
        return ((TelephonyManager) getSystemService("phone")).getSubscriberId();
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.gps = new GPSTracker(this.context);
        this.lat = this.gps.latitude;
        this.log = this.gps.longitude;
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", 1).show();
    }

    public void onStart(Intent paramIntent, int paramInt) {
        super.onStart(paramIntent, paramInt);
        Toast.makeText(this, "Service Started", 1).show();
        compareSIM();
    }
}
