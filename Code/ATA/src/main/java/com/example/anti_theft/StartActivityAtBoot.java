package com.example.anti_theft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StartActivityAtBoot extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    public void onReceive(Context paramContext, Intent paramIntent) {
        if (paramIntent.getAction().equals(ACTION)) {
            paramContext.startService(new Intent(paramContext, CompareIMSI.class));
            Toast.makeText(paramContext, "CompareIMSI service has started!", 1).show();
        }
    }
}
