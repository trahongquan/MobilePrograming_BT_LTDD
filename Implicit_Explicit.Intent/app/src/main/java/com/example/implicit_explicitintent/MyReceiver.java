package com.example.implicit_explicitintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int number1 = intent.getIntExtra("number1", 0);
        int number2 = intent.getIntExtra("number2", 0);

        // Hiển thị dữ liệu lên toast
        Toast.makeText(context, "Number 1: " + number1 + ", Number 2: " + number2, Toast.LENGTH_SHORT).show();
        Log.i("xxxxxx", "chạy dồi");

    }
}