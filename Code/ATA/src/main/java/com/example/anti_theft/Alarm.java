package com.example.anti_theft;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Alarm extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alarm, menu);
        return true;
    }
}
