package com.example.bt_click_create_dialog;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_activity1);

        // Hiển thị thông báo
        TextView textView = findViewById(R.id.textView);
        textView.setText("Thông báo từ SubActivity1");
        Log.i("test.log", "onCreate SubActivity1");
    }
}
