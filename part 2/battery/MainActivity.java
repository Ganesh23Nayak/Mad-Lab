package com.example.battery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView battery;
BroadcastReceiver b;
ConstraintLayout c;
ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=findViewById(R.id.body);
        battery=findViewById(R.id.battery);
        p=findViewById(R.id.progressBar);
        b=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                battery.setText(String.valueOf(level));
                p.setProgress(level);
                if(level>=80)
                {
                    c.setBackgroundColor(Color.GREEN);
                }else if(level>=40)
                {
                    c.setBackgroundColor(Color.YELLOW);
                }else{
                    c.setBackgroundColor(Color.RED);
                }

            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b);
    }
}