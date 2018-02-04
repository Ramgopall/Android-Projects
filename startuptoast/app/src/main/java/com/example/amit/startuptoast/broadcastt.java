package com.example.amit.startuptoast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Amit on 7/20/2017.Intent serviceIntent = new Intent(context, AutoStartUp.class);
 context.startService(serviceIntent);
 */

public class broadcastt extends BroadcastReceiver {
    Context mContext;
    private final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent alarmIntent = new Intent(context, MyService.class);
       context.startService(alarmIntent);





    }




}