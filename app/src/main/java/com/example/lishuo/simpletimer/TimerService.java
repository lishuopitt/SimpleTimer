package com.example.lishuo.simpletimer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lishuo on 2/4/2016.
 */
public class TimerService  extends Service {
    final static String MY_ACTION = "MY_ACTION";
    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        MyThread myThread = new MyThread();
        myThread.start();

        return super.onStartCommand(intent, flags, startId);
    }
    public class MyThread extends Thread{

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while(true){
                try {
                    Log.i("Time", "Sending from serivice");
                    Thread.sleep(5000);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String currentDateandTime = sdf.format(new Date());
                    Intent intent = new Intent();
                    intent.setAction(MY_ACTION);
                    intent.putExtra("Time", currentDateandTime);
                    sendBroadcast(intent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
