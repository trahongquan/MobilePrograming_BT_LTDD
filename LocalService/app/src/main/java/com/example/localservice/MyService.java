package com.example.localservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder. Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        MyService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the binder
        return mBinder;
    }

    /**
     * Method for clients
     */
    public int getRandomNumber() {
        // Generate a random number
        return mGenerator.nextInt(100);
    }
}