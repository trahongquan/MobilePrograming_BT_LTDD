package com.example.bt_click_create_dialog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_activity2);

        // Hiển thị thông báo
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Thông báo ");
    }
}