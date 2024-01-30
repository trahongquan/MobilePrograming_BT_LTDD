package com.example.servicetestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGetRandomNumber;
    TextView tvRandomNumber;

    boolean mBound =  false;
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetRandomNumber = (Button) findViewById(R.id.btnGetRandomNumber);
        tvRandomNumber = (TextView) findViewById(R.id.tvRandomNumber);

        btnGetRandomNumber.setOnClickListener(this);
        //bind Service
        Intent intent = new Intent(MainActivity.this, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    public void onClick(View v) {
        //Get a random number from Service
        if(mBound == true){
            int randomNumber = myService.generateRandomNumber();
            tvRandomNumber.setText(randomNumber + "");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unBind Service
        if(mBound == true) {
            unbindService(mConnection);
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder iBinder =  (MyService.LocalBinder) service;
            myService =  iBinder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound =  false;
        }
    };

}