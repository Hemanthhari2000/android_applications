package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TimePicker alarmTime;
    TextClock currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTime = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), 	RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
        Timer t = new Timer();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.d("111",currentTime.getText().toString());
                Log.d("222",AlarmTime());
                if (currentTime.getText().toString().equals(AlarmTime())){
                    r.play();
                }
                else{
                    r.stop();
                }
            }
        }, 0, 1000);
    }
    public String AlarmTime(){
        Integer alarmHours,alarmMinutes;
        alarmHours = alarmTime.getCurrentHour();
        alarmMinutes = alarmTime.getCurrentMinute();
        String stringAlarmTime;

        if(alarmMinutes<10){
            stringAlarmTime = alarmHours.toString()+": 0"+alarmMinutes.toString();
        }
        else
            stringAlarmTime = alarmHours.toString()+":"+alarmMinutes.toString();
        return stringAlarmTime;
    }
}
