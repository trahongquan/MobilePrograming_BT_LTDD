package com.example.servicetestapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {

    public final LocalBinder iBinder = new LocalBinder();
    public final Random mGenerator = new Random();

    public MyService() {
    }

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public int generateRandomNumber(){
        return mGenerator.nextInt(100);
    }

}