package com.example.modul2_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import kotlin.reflect.KClass;

public class MainActivity extends AppCompatActivity {
    private void checkData2Notice(Object data){
        /** Cách dùng Builder để truyền data*/
        // Tạo một đối tượng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Đặt tiêu đề cho hộp thoại
        builder.setTitle("Thông báo: ");
        // Đặt nội dung thông báo cho hộp thoại
        builder.setMessage((String) data);
        // Hiển thị hộp thoại
        builder.show();
    }
    private void addBuilderData(Object data){
        // Tạo một Bundle mới
        Bundle bundle = new Bundle();
        // Thêm dữ liệu vào Bundle
        if (data instanceof Integer) bundle.putInt("data", (int) data);
        if (data instanceof String) bundle.putString("data", (String) data);
        // Khởi chạy Sub Activity
        startActivity(new Intent(this, Layout.class).putExtras(bundle));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Đóng app", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            Toast.makeText(this, "Đóng app", Toast.LENGTH_SHORT).show();
            checkData2Notice("Đóng app");
        });
        /****************************************/

        ImageView imageView1 = findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.luffy);

        findViewById(R.id.button2).setOnClickListener(v -> {
            addBuilderData(R.drawable.luffy);
        });

        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.banner6);
        findViewById(R.id.button3).setOnClickListener(v -> {
            addBuilderData(R.drawable.banner6);
        });
    }
}