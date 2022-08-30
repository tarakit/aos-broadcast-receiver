package com.istad.aos_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;
    IntentFilter filter;
    Button listenButton;
    Intent batteryStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenButton = findViewById(R.id.listenButton);
        // initialize Receiver of BroadcastReceiver extended custom class
        myReceiver = new MyReceiver();


        listenButton.setOnClickListener(view -> {
            registerReceiver(myReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }

}