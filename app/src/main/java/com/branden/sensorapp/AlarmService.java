package com.branden.sensorapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Branden on 27/10/2015.
 */
public class AlarmService {

    private AlarmManager mAlarmManager;
    private PendingIntent mAlarmIntent;

    public AlarmService() {

    }

    public void createAlarm(Context context, Calendar calendar) {
        // Create a timed Intent
        mAlarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReciever.class);
        mAlarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        //Set time for the alarm to go off
        mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), mAlarmIntent);

    }

    public void cancelAlarm() {

    }
}
