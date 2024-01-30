package com.example.started_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button start, stop;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    start = findViewById(R.id.button);
    stop = findViewById(R.id.button2);
    start.setOnClickListener(this);
    stop.setOnClickListener(this);
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    // Method to start the service
    public void startService(View view) {
        Intent intent = new Intent(getBaseContext(), MyService.class);
        startService(intent);
        Log.i("Servicetest", "startService");
    }

    // Method to stop the service
    public void stopService(View view) {
        Intent intent = new Intent(getBaseContext(), MyService.class);
        stopService(intent);
        Log.i("Servicetest", "stopService");
    }

    @Override
    public void onClick(View v) {
        if(v==start){
            startService(v);
        } else if (v==stop) {
            stopService(v);
        }
    }
}
