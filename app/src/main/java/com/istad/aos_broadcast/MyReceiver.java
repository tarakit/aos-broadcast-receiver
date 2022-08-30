package com.istad.aos_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private String TAG = "MyReceiver";
    public MyReceiver(){}

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkStatus.getConnectivityStatusString(context);

        if(status.isEmpty()||status.equals("No internet is available")||status.equals("No Internet Connection")) {
            status="No Internet Connection";
        }

        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }
}
