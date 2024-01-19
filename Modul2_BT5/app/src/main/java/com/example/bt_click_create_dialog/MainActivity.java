package com.example.bt_click_create_dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
            Log.i("test.log", "button 1");
                Intent intent=new Intent(arg.getContext(), SubActivity1.class);
                startActivity(intent);
            }
        });
        Button btn2= (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i("test.log", "button 2");
                Intent intent=new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một đối tượng AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Đặt tiêu đề cho hộp thoại
                builder.setTitle("Thông báo");

                // Đặt nội dung thông báo cho hộp thoại
                builder.setMessage("Đây là thông báo");

                // Hiển thị hộp thoại
                builder.show();
            }
        });
        Log.i("test.log", "onCreate");

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Tạo một đối tượng NotificationManager
//                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//                // Tạo một đối tượng NotificationCompat.Builder
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "channel_id");
//
//                // Đặt tiêu đề cho thông báo
//                builder.setContentTitle("Thông báo");
//
//                // Đặt nội dung thông báo cho thông báo
//                builder.setContentText("Đây là thông báo");
//
//                // Đặt biểu tượng cho thông báo
//                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
//
//                // Tạo một đối tượng Notification
//                Notification notification = builder.build();
//
//                // Hiển thị thông báo
//                notificationManager.notify(1, notification);
//
//            }
//        });



    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "channel_id");
//
//        // Đặt tiêu đề cho thông báo
//        builder.setContentTitle("Thông báo");
//
//        // Đặt nội dung thông báo cho thông báo
//        builder.setContentText("Đây là thông báo");
//
//        // Đặt biểu tượng cho thông báo
//        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
//
//        // Tạo một đối tượng Notification
//        Notification notification = builder.build();
//        if (requestCode == 1) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Quyền đã được cấp, tiến hành hiển thị thông báo
//                notificationManager.notify(1, notification);
//            } else {
//                // Quyền không được cấp, xử lý trường hợp này
//                Toast.makeText(this, "Không thể hiển thị thông báo vì thiếu quyền", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}