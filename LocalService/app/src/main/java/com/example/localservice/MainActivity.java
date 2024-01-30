package com.example.localservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyService mService;
    boolean mBound = false;

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(this);
        // Bind to LocalService
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();

        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    /**
     * Called when a button is clicked (the button in the layout file attaches
     * to this method with the android:onClick attribute)
     */
    @Override
    public void onClick(View v) {
        if (v==button) {
            if (mBound) {
                // Get a random number from the service
                int num = mService.getRandomNumber();
                Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
                textView.setText("number: " + num);
            }
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
            Log.i("Service_Button", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
//            mService = null;
            mBound = false;
        }
    };

}