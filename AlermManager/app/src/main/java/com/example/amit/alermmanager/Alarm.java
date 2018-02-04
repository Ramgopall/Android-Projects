package com.example.amit.alermmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by Amit on 3/23/2017.
 */

public class Alarm extends BroadcastReceiver{
    public static MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {

        mp = MediaPlayer.create(context,R.raw.max);
        mp.start();
    }


}
