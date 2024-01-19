package com.example.modul2_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Layout extends AppCompatActivity {
    private void checkData2Notice(Object data){
        /** Cách dùng Builder để truyền data*/
        // Tạo một đối tượng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(Layout.this);
        // Đặt tiêu đề cho hộp thoại
        builder.setTitle("Thông báo: " + R.drawable.luffy + data);
        // Đặt nội dung thông báo cho hộp thoại
        builder.setMessage((String) data);
        // Hiển thị hộp thoại
        builder.show();
    }

    private void ShowImage(ImageView imageView){
        Bundle bundle = getIntent().getExtras();
        int data = bundle.getInt("data", 0); //set giá trị defautl = 0
        if(bundle.containsKey("data")) imageView.setImageResource(data);
        // kiểm tra có key data trong Bundle hay không
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ShowImage(findViewById(R.id.imageView));
        Button button = findViewById(R.id.button4);
        button.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}